require 'net/http'
require 'json'

puts "#{ARGV.join(" ")}"

Then(/^I perform DQTest (.*)$/) do |arg|

	uri = URI.parse('http://localhost:38383/a11ytest/' + String.new(arg).downcase)
	http = Net::HTTP.new(uri.host, uri.port)
	request = Net::HTTP::Get.new(uri.request_uri)

	response = http.request(request)

	sleep(1.0) #TODO: This shouldn't be necessary.  Need to fix this in the A11yService

	if (response.body.include?('FAIL'))
		json = JSON.parse(response.body)
		puts response.body
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