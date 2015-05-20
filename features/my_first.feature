Feature: Login feature

  Scenario: I can navigate to different stories
    When I press "Labels"
    When I press "Broken"
    Then take picture
    Then I press "Fixed"
    Then take picture
    Then I perform DQTest all