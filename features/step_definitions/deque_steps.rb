require 'net/http'
require 'json'

RESULTS_DIR = Dir.pwd + "/DequeTestResults"
Dir.mkdir(RESULTS_DIR) unless File.exists?(RESULTS_DIR)

Then(/^I perform DQTest (.*)$/) do |arg|

	uri = URI.parse('http://localhost:38383/a11ytest/' + String.new(arg).downcase)
	http = Net::HTTP.new(uri.host, uri.port)
	request = Net::HTTP::Get.new(uri.request_uri)

	response = http.request(request)

	sleep(1.0) #TODO: This shouldn't be necessary.  Need to fix this in the A11yService

	if (response.body.include?('FAIL'))
		screenshot({:name=>RESULTS_DIR+"/deque_test_failure.png"})
		puts "Deque Accessibility Test Failed"
		json = JSON.parse(response.body)
		puts response.body + "\n"
	end
end