require 'net/http'
require 'json'

dq_html_output=false

port_number=ENV["DQ_TEST_PORT"]

if (!defined? port_number || port_number == 0)
	port_number=38383
end

ARGV.each_with_index { |value, index| 
	if (value == "--format")
		if (ARGV[index+1] == "html")
			dq_html_output=true
		end
	end
}

Then(/^I perform DQTest (.*)$/) do |arg|

	uri = URI.parse('http://localhost:' + port_number.to_s + '/a11ytest/' + String.new(arg).downcase)
	http = Net::HTTP.new(uri.host, uri.port)
	request = Net::HTTP::Get.new(uri.request_uri)

	begin 
		response = http.request(request)
	rescue EOFError
		raise "Coult not connect to Accessibility Analyzer service on device.  Is it running?"
	end

	sleep(1.0) #TODO: This shouldn't be necessary.  Need to fix this in the A11yService

	if (response.body.include?('FAIL') || response.body.include?('WARN'))
		responseObject = JSON.parse(response.body)
		
		if (dq_html_output)
			htmlString = ""

			responseObject["ruleResults"].each { |result|

				colorString = "red"
				
				if (result["status"] == "PASS")
					colorString = "green"
				end
					
				htmlString.concat("<p><b><font color=\"" + colorString + "\">" + result["status"] + "</font></b> " + result["message"]+ "</b></p>")

				result["failedNodes"].each { |failedNode|
					htmlString.concat("<blockquote><i>" + failedNode + "</i></blockquote>")
				}
			}

			puts htmlString
		else 
			puts response.body
		end

		raise "Deque Accessibility Test Failed"
	end
end
