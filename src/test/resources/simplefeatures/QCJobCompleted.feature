#Author: Abhishek Yadav
#Keywords Summary : Quality Check Job Completed
Feature: QC Job Completed Job API Feature
  As a Quality Check user of the application. I should be able complete QC job using the job number and Quality Check authorization token.

  Scenario: QC Job Completed API Scenario
    Quality Check user will login into the application and complete QC job using the job number

    Given the Base URL is "http://139.59.91.96:9000" endpoint is "/v1/qc" and the Quality Check authorization token
    And Header should content-type should be in "application/Json"
    And the request body should contain a json object with the job number 16689
    When Quality Check Job Completed POST api request is made
    Then Response Statuscode Should be 200
    And response body is in JSON Format
    And response Body contain Message "QC completed successfully"
    And response Should be available in less than 1000 ms
