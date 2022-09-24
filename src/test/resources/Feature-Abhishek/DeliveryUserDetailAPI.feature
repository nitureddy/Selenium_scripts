#Author: Abhishek Yadav
#Keywords Summary : Delivery User Details 


Feature: Delivery User Details API Feature
As a Delivery user of the application. I should be able to verify Delivery user details using Delivery authorization token.

Scenario:  Delivery User Detail API Scenario
    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the Delivery authorization token
    When Delivery User Detail api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message "Success"
    And response body should contain login_id "iamfd"
    And response body should contain email_id "email_id": "mark@gmail.com"
    And response body should contain mobile_number "8899776655"
    And response should be available in less than 1000 ms
