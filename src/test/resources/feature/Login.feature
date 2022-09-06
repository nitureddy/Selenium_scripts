#Author: Jatin Shharma
#Keywords Summary : Login API Test

Feature: Test Phoenix Backend Application
  In order to test the Phoenix Backend Application
  As a user
  I should to be able to login in the application with help of API

  @tag1
  Scenario: Login API Test
  login to phoenix application via backend
    Given backend URL and endpoint
    When user enters their credentials
    Then token should be generated with message as success

