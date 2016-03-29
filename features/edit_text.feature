Feature: EditText Story
	@EditText @all
	Scenario: The Edit Texts Story is Accessible
		* I press "Edit Texts"
		* I press "Fixed"
		* I perform silent DQTest 
		* I press "Broken"
		* I perform silent DQTest ?ruleEditText=true&unspecified=false