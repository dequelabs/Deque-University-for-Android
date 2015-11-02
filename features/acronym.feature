Feature: Acronym Announcement Story
	@AcronymAnnouncement @all
	Scenario: The Acronym Announcement Story is Accessible
		* I press "Acronym Announcement"
		* I press "Fixed"
		* I perform silent DQTest 
		* I press "Broken"
		* I perform silent DQTest 
