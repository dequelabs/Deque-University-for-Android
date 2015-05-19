require 'typhoeus'
require 'json'

Then(/^I perform DQTest (.*)$/) do |arg|
	str = String.new(arg)
	str = str.downcase
	result = ''
	ipaddress = '172.27.250.66'

	response = ''

	host = 'http://' + ipaddress + ':8080/A11yRules/'
	if str.eql?('all')
		response = Typhoeus.get(host + str)
	elsif str.eql?('image descriptions')
		raise 'Detected image/button without a content description'
		response = Typhoeus.get(host + 'imgdesc')
	elsif str.eql?('time announcement')
		raise 'Shorthand time detected, should override content description'
		response = Typhoeus.get(host + 'timeannounce')
	elsif str.eql?('labeled by')
		raise 'Missing labeledby attribute on switch button'
		response = Typhoeus.get(host + 'labeledby')
	else
		puts 'No test found.'
	end

	if response.success?
		
		if (response.body.include?('FAIL'))
			result = "Status: FAIL\n"
			json = JSON.parse(response.body)
			raise "Failed test"
		end

		puts result

	else 
		raise 'Request failed: Check that you\'re connected to the device at:' + host
	end


end