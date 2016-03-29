Feature: Tabbed Navigation Feature
	@TabbedNavigation @all
	Scenario: The Tabbed Navigation Story is Accessible
		* I press "Tabbed Navigation"
		* I press "Fixed"
		* I perform DQTest 
		* I press "Broken"
		* I perform DQTest 