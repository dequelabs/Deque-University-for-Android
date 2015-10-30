Feature: Label Story
	@Labels @all
  	Scenario: The Labels Story is Accessible
    	When I press "Labels"
	    When I press "Fixed"
	    Then I perform DQTest 
	    Then I press "Broken"
	    Then I perform DQTest 