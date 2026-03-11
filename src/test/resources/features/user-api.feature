Feature: User API

  Scenario: Get user by id
    Given user with id 1 exists
    When I request user by id 1
    Then response status should be 200