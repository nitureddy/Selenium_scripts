#Author: Abhishek Yadav
#Keywords Summary : Quality Check Job Completed


Feature: QC Job Completed Job API Feature
As a Quality Check user of the application. I should be able complete QC job using the job number and Quality Check authorization token.

 Scenario:  QC Job Completed API Scenario
 	Quality Check user will login into the application and complete QC job using the job number
		Given the Base URL is "139.59.91.96:9000" endpoint is "/v1/qc" and the Quality Check authorization token
		And the Header should content-Type should be in "application/Json"
		And the request body should contain a json object with the job number
    When Quality Check Job Completed api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message and data   
    And response body should contain message "QC completed successfully"
    And response should be available in less than 1000 ms
   