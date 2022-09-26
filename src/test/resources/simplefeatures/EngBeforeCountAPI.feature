#Author: Abhishek Yadav
#Keywords Summary : Before Count
Feature: Before Count API Feature
  As a Engineer user of the application. I should be able to get the count of Pending for repair and Repair completed before the Repair Job done by the Engineer using Engineer authorization token.

  Scenario: Engineer Before Count API Scenario
    Engineer will login into the application and get the count of Pending for repair and Repair completed before completing the Repair Job

    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Eng authorization token
    When Eng Before Count GET api request is made
    Then Response statuscode should be 200
    And Response Body should be in JSON
    And response body should contain label Pending for repair "Pending for repair"
    And response body should contain Pending for repair count
    And response body should contain label Repair completed "Repair completed"
    And response body should contain Repair completed count
    And Response Time should be less than 1000 ms
