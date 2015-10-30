Feature: Acronym Announcement Story
	@AcronymAnnouncement @all
	Scenario: The Acronym Announcement Story is Accessible
		* I press "Acronym Announcement"
		* I press "Fixed"
		* I perform DQTest 
		* I press "Broken"
		* I perform DQTest 
