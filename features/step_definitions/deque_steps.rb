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

def getHtmlString(results, statusString, colorString) 
	htmlString = ""

	results.each { |result|
		htmlString.concat("<p><b><font color=\"" + colorString + "\">" + statusString + " </font></b>" + result["message"] + "</p>")

		result["nodes"].each { |node|
			htmlString.concat("<blockquote><i>" + node + "</i></blockquote>")
		}
	}

	return htmlString
end

def runTestWithURL(url, silent, html_output) 

	uri = URI.parse(url)
	http = Net::HTTP.new(uri.host, uri.port)
	request = Net::HTTP::Get.new(uri.request_uri)

	begin 
		response = http.request(request)
	rescue EOFError
		raise "Could not connect to Accessibility Analyzer service on device.  Is it running?"
	end

	responseObject = JSON.parse(response.body)
	
	if (html_output)
		htmlString = ""

		htmlString.concat(getHtmlString(responseObject["fail"], "FAIL", "red"))
		htmlString.concat(getHtmlString(responseObject["warn"], "WARN", "yellow"))
		htmlString.concat(getHtmlString(responseObject["pass"], "PASS", "green"))

		puts htmlString
	else 
		puts response.body
	end

	if (!silent && responseObject["testStatus"] == "FAIL")
		raise "Deque Accessibility Test Failed"
	end
end

Then(/^I perform DQTest$/) do 
	runTestWithURL('http://localhost:' + port_number.to_s + '/a11ytest', false, dq_html_output)
end

Then(/^I perform DQTest (.*)$/) do |arg|
	runTestWithURL('http://localhost:' + port_number.to_s + '/a11ytest' + arg.to_s, false, dq_html_output)	
end

Then(/^I perform a silent DQTest$/) do 
	runTestWithURL('http://localhost:' + port_number.to_s + '/a11ytest', true, dq_html_output)
end
