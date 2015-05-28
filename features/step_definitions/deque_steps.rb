require 'net/http'
require 'json'

dq_html_output=false

ARGV.each_with_index { |value, index| 
	if (value == "--format")
		if (ARGV[index+1] == "html")
			dq_html_output=true
		end
	end
}

Then(/^I perform DQTest (.*)$/) do |arg|

	uri = URI.parse('http://localhost:38383/a11ytest/' + String.new(arg).downcase)
	http = Net::HTTP.new(uri.host, uri.port)
	request = Net::HTTP::Get.new(uri.request_uri)

	response = http.request(request)

	sleep(1.0) #TODO: This shouldn't be necessary.  Need to fix this in the A11yService

	if (response.body.include?('FAIL'))
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
#Just want to adda  line because blarg

      # {
      #     "testStatus": "FAIL",
      #     "ruleResults": [
      #         {
      #             "status": "PASS",
      #             "message": "Check images for proper content descriptions.",
      #             "failedNodes": []
      #         },
      #         {
      #             "status": "FAIL",
      #             "message": "Check controls for alternative text labels.",
      #             "failedNodes": [
      #                 "android.widget.Switch",
      #                 "android.widget.Switch",
      #                 "android.widget.Switch"
      #             ]
      #         },
      #         {
      #             "status": "PASS",
      #             "message": "Check EditText boxes for visual labels",
      #             "failedNodes": []
      #         }
      #     ]
      # }