#Author: Abhishek Yadav
#Keywords Summary : Assign Job 


Feature: Assign Job API Feature 
As a Supervior user of the application. I should be able to assign job to the Engineer using jobId and engineerId


  Scenario:  Assign Job API Scenario
    Given the Base URL is "139.59.91.96:9000" endpoint is "v1/assign" and the supervior authorization token
		And the Header should content-Type should be in "application/Json"
		And the request body should contain a json object with jobId and engineer ID
    When Assign Jobs api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message and data   
    And response body should contain message "Engineer assigned successfully"
    And response should be available in less than 1000 ms
   