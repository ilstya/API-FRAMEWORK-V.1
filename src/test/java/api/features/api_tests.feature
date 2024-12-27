Feature: API Tests

  @api
  Scenario: Validate user details from reqres.in
    Given I send a GET request to "https://reqres.in/api/users/2"
    When I receive the response
    Then the response status code should be 200
    And the user name should be "Janet"
