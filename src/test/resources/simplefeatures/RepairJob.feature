#Author: Abhishek Yadav
#Keywords Summary : Repair Job


Feature: Repair Job API Feature
As a Engineer user of the application. I should be able to Repair the Job using job number and problems and Engineer authorization token


  Scenario:  Repair Job API Scenario
  	Engineer will login into the application and Repair the Job using job number and problems	
			Given the Base URL is "139.59.91.96:9000" endpoint is "/v1/engineer/repaircomplete" and the Engineer authorization token
			And the Header should content-Type should be in "application/Json"
			And the request body should contain a json object with job number and problems
	    When Repair Job api request is made
	    Then response status code should be 200
	    And response body should be in JSON format
	    And response body should contain message and data   
	    And response body should contain message "Repair successful."
	    And response should be available in less than 1000 ms
