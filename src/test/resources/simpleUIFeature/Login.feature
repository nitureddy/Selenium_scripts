#Author: your.email@your.domain.com
#Keywords Summary :
@tag
Feature: Login Feature for Phoenix WebApplication
  As a user of the is application I should be able to login.

  @tag1
  Scenario: Login Scenario
  Verify user login scenario
    Given the user launches the "Chrome" Browser and is on Login Page
    When the user enters the credentials "iamfd" and "password"
    Then the user should see the userName under userIcon
