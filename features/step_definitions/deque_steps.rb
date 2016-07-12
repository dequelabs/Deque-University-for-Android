require 'net/http'
require 'json'

dq_html_output=false

port_number=ENV["DQ_TEST_PORT"]

if (!defined? port_number || port_number == 0)
	port_number=38383
end

device_test_url='http://localhost:' + port_number.to_s + '/a11ytest'

ARGV.each_with_index { |value, index| 
	if (value == "--format")
		if (ARGV[index+1] == "html")
			dq_html_output=true
		end
	end
}

def getHtmlString(results) 
	htmlString = ""
	failString = ""
	warnString = ""
	minorString = ""

	results.each { |result|
		resultObject = result["nodes"]
		if (result["impact"] == "critical") 
			statusString = "FAIL"
			colorString = "red"
			resultObject.each { |resultObject2|
				failString.concat("<p><b><font color=\"" + colorString + "\">" + statusString + 
				" </font> Object: </b>" + resultObject2["json"]["classname"] + 
				" <b>Position:</b> Right: " + resultObject2["json"]["rect"]["right"].to_s + " Left: " + resultObject2["json"]["rect"]["left"].to_s +
					" Top: " + resultObject2["json"]["rect"]["top"].to_s + " Bottom: " + resultObject2["json"]["rect"]["bottom"].to_s +
				" <br>&emsp;<b>Fix all of: </b>" + result["description"] + "</p>")
			}
		elsif (result["impact"] == "moderate")
			statusString = "WARN"
			colorString = "orange"
			resultObject.each { |resultObject2|
				warnString.concat("<p><b><font color=\"" + colorString + "\">" + statusString + 
				" </font> Object: </b>" + resultObject2["json"]["classname"] + 
				" <b>Position:</b> Right: " + resultObject2["json"]["rect"]["right"].to_s + " Left: " + resultObject2["json"]["rect"]["left"].to_s +
					" Top: " + resultObject2["json"]["rect"]["top"].to_s + " Bottom: " + resultObject2["json"]["rect"]["bottom"].to_s +
				" <br>&emsp;<b>Fix all of: </b>" + result["description"] + "</p>")
			}
		elsif (result["impact"] == "minor") 
			statusString = "MINOR"
			colorString = "blue"
			resultObject.each { |resultObject2|
				minorString.concat("<p><b><font color=\"" + colorString + "\">" + statusString + 
				" </font> Object: </b>" + resultObject2["json"]["classname"] + 
				" <b>Position:</b> Right: " + resultObject2["json"]["rect"]["right"].to_s + " Left: " + resultObject2["json"]["rect"]["left"].to_s +
					" Top: " + resultObject2["json"]["rect"]["top"].to_s + " Bottom: " + resultObject2["json"]["rect"]["bottom"].to_s +
				" <br>&emsp;<b>Fix all of: </b>" + result["description"] + "</p>")
			}	
		end
		
	}

	htmlString = htmlString.concat(failString + warnString + minorString)

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

		htmlString.concat(getHtmlString(responseObject["violations"]))

		puts htmlString
	else 
		puts response.body
	end

	if (!silent && responseObject["testStatus"] == "FAIL")
		raise "Deque Accessibility Test Failed"
	end
end

Then(/^I perform DQTest$/) do 
	runTestWithURL(device_test_url, false, dq_html_output)
end

Then(/^I perform DQTest (.*)$/) do |arg|
	runTestWithURL(device_test_url + arg.to_s, false, dq_html_output)	
end

Then(/^I perform silent DQTest$/) do 
	runTestWithURL(device_test_url, true, dq_html_output)
end

Then(/^I perform silent DQTest (.*)$/) do |arg|
	runTestWithURL(device_test_url + arg.to_s, false, dq_html_output)	
end
