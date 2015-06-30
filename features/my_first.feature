Feature: Login feature
	@Labels @all
  	Scenario: The Labels Story is Accessible
    	When I press "Labels"
	    When I press "Fixed"
	    Then I perform DQTest all
	    Then I press "Broken"
	    Then I perform DQTest all

	@ContDesc @all
	Scenario: The Content Descriptions Story is Accessible
		* I press "Content Descriptions"
		* I press "Fixed"
		* I perform DQTest all
		* I press "Broken"
		* I perform DQTest all

	@EditText @all
	Scenario: The Edit Texts Story is Accessible
		* I press "Edit Texts"
		* I press "Fixed"
		* I perform DQTest all
		* I press "Broken"
		* I perform DQTest all

	@TabbedNavigation @all
	Scenario: The Tabbed Navigation Story is Accessible
		* I press "Tabbed Navigation"
		* I Press "Fixed"
		* I perform DQTest all
		* I press "Broken"
		* I perform DQTest all

	@AcronymAnnouncement @all
	Scenario: The Acronym Announcement Story is Accessible
		* I press "Acronym Announcement"
		* I press "Fixed"
		* I perform DQTest all
		* I press "Broken"
		* I perform DQTest all
