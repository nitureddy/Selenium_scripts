#Author: Abhishek Yadav
#Keywords Summary : After Count


Feature: After Count API Feature
As a Engineer user of the application. I should be able to get the count of Pending for repair and Repair completed after the Repair Job done by the Engineer using Engineer authorization token.


  Scenario: Engineer After Count API Scenario
    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Engineer authorization token
    When After Count api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain label "Pending for repair", count
    And response body should contain label "Repair completed", count should be incremented by 1
    And response should be available in less than 1000 ms