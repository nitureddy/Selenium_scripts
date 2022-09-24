#Author: Abhishek Yadav
#Keywords Summary : Repair Job


Feature: Repair Job API Feature File
As a Eng user of the application Repair job Completed.


  Scenario:  Repair Job API Scenario
    Given the endpoint and the Eng authorization token
		And the contant-Type should be in "application/Json"
		And entering the job_number and problems
    When Repair Job api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message and data   
    And response body should contain message "Repair successful."
    And response should be available in less than 1000 ms
   