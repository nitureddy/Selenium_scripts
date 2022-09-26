#authorName: Abhishek Yadav
#Keywords Summary : Login API
Feature: Login API Feature
  As a user of the application when I try to login using the right credentials the login api should generate a token.

 Scenario: Login API Scenario
    User is making login api request using valid credentials

    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/login"
    And the Header should have content-Type "application/Json"
    And the request body should contain a json object with the credentials username and password
    When login POST api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message as "Success"
    And response body should contain a valid token
    And the execution time should be less then 1000 ms