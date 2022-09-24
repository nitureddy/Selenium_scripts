#Author: Abhishek Yadav
#Keywords Summary : Assign Job 


Feature: Assign Job API Feature File
As a Sup user of the application Assign job to the Engineer.


  Scenario:  Assign Job API Scenario
    Given the endpoint and the Sup authorization token
		And the contant-Type should be in "application/Json"
		And entering the job_number and engineer_id
    When Assign Jobs api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message and data   
    And response body should contain message "Engineer assigned successfully"
    And response should be available in less than 1000 ms
   