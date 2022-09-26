#Author: Abhishek Yadav
#Keywords Summary : After Count
Feature: After Count API Feature
  As a Engineer user of the application. I should be able to get the count of Pending for repair and Repair completed after the Repair Job done by the Engineer using Engineer authorization token.

  Scenario: Engineer After Count API Scenario
    Engineer will login into the application and get the count of Pending for repair and Repair completed after completing the Repair Job

    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the engineer authorization token
    When Eng After Count GET api request is made
    Then response statuscode have be 200
    And response Body should be in JSON Format
    And response body contain label Pending for repair "Pending for repair"
    And response body contain Pending for repair count
    And response body contain label Repair completed "Repair completed"
    And response body should contain Repair completed count is increased by one
    And The response Time should be less than 1000 ms
