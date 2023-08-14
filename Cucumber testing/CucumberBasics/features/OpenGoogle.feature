Feature: Login Validation

  Scenario: Login with a valid-user

    Given the user is on the Home page
    And the User navigate to the Login page
    And the user enters username and password
    Then the successful login message is displayed with text