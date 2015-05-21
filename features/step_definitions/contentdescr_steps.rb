require 'net/http'
require 'json'

Then(/^I perform DQTest (.*)$/) do |arg|
	str = String.new(arg).downcase

	result = ''

	host = 'http://localhost:38383/a11ytest/' + str

	uri = URI.parse(host)

	http = Net::HTTP.new(uri.host, uri.port)
	request = Net::HTTP::Get.new(uri.request_uri)

	response = http.request(request)

	sleep(1.0)

	if (response.body.include?('FAIL'))
		screenshot({:name=>"deque_test_failure.png"})
		puts "Deque Accessibility Test Failed"
		json = JSON.parse(response.body)
		puts response.body + "\n"
	end
end