#Author: Abhishek Yadav
#Keywords Summary : After Count


Feature: After Count API Feature
As a Quality Check user of the application. I should be able to get the count of Pending for QC, QC Completed and QC Rejected after the QC job is completed by the Quality Check using Quality Check authorization token.

  Scenario:  After Count API Scenario
    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Quality Check authorization token
    When After Count api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain label "Pending for QC" and count
    And response body should contain label "QC Completed" and count should be incremented by 1
    And response body should contain label "QC Rejected" and count
    And response should be available in less than 1000 ms