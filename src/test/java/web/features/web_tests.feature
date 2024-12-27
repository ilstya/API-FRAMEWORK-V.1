Feature: Web UI Tests

  @web
  Scenario: Validate login on demoblaze.com
    Given I navigate to "https://www.demoblaze.com"
    When I click on the "Log in" button
    And I enter username "testuser" and password "password123"
    Then I should see the welcome message "Welcome testuser"
