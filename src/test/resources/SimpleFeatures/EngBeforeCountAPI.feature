#Author: Abhishek Yadav
#Keywords Summary : Before Count


Feature: Before Count API Feature
As a Engineer user of the application. I should be able to get the count of Pending for repair and Repair completed before the Repair Job done by the Engineer using Engineer authorization token.


  Scenario: Engineer Before Count API Scenario
  	Engineer will login into the application and get the count of Pending for repair and Repair completed before completing the Repair Job
	    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Engineer authorization token
	    When Before Count api request is made
	    Then response status code should be 200
	    And response body should be in JSON format
	    And response body should contain label "Pending for repair", count
	    And response body should contain label "Repair completed", count
	    And response should be available in less than 1000 ms