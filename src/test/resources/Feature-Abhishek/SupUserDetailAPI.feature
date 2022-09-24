#Author: Abhishek Yadav
#Keywords Summary : Supervior User Details 


Feature: Supervior User Details API Feature
As a Supervior user of the application. I should be able to verify Supervior user details using Supervior authorization token.

  Scenario:  Supervior User Detail API Scenario
    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the Supervior authorization token
    When Supervior User Detail api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message "Success"
    And response body should contain login_id "iamsup"
    And response body should contain email_id "email_id": "john@gmail.com"
    And response body should contain mobile_number "9988778899"
    And response should be available in less than 1000 ms
   