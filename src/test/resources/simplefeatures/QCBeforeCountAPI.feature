#Author: Abhishek Yadav
#Keywords Summary : Before Count
Feature: Before Count API Feature
  As a Quality Check user of the application. I should be able to get the count of Pending for QC, QC Completed and QC Rejected before the QC job is completed by the Quality Check using Quality Check authorization token.

  Scenario: Before Count API Scenario
    Quality Check user will login into the application and get the count of Pending for QC, QC Completed and QC Rejected before the QC job is completed

    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the QC authorization token
    When Quality Check Before Count GET api request is made
    Then response status code have to be 200
    And response Body should be in JSON
    And response body contain label Pending for QC "Pending for QC"
    And response body should contain Pending for QC count
    And response body contain label QC Completed "QC Completed"
    And response body should contain QC Completed count
    And response body contain label QC Rejected "QC Rejected"
    And response body should contain QC Rejected count
    And response Time should be less than 1000 ms
