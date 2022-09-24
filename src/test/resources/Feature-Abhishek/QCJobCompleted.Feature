#Author: Abhishek Yadav
#Keywords Summary : QC Job Completed


Feature: QC Job Completed Job API Feature File
As a QC user of the application QC Job Completed.


  Scenario:  QC Job Completed API Scenario
    Given the endpoint and the QC authorization token
		And the contant-Type should be in "application/Json"
		And entering the job_number
    When QC Job Completed api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message and data   
    And response body should contain message "QC completed successfully"
    And response should be available in less than 1000 ms
   