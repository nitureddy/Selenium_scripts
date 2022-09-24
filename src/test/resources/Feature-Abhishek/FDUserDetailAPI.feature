#Author: Abhishek Yadav
#Keywords Summary : FrontDesk User Details 


Feature: FrontDesk User Details API Feature
As a FrontDesk user of the application. I should be able to verify FrontDesk user details using FrontDesk authorization token.

  Scenario:  FrontDesk User Detail API Scenario
    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the FrontDesk authorization token
    When FrontDesk User Detail api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message "Success"
    And response body should contain login_id "iamfd"
    And response body should contain email_id "email_id": "mark@gmail.com"
    And response body should contain mobile_number "8899776655"
    And response should be available in less than 1000 ms
