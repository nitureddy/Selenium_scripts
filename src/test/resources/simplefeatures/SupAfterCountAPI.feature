#Author: Abhishek Yadav
#Keywords Summary : After Count


Feature: After Count API Feature
As a Supervior user of the application. I should be able to get the count of Pending for assignment, Pending for repair and Pending for delivery after the Assign job is completed by the Supervior using Supervior authorization token.


  Scenario:  After Count API Scenario
  	Supervior user will login into the application and get the count of Pending for assignment, Pending for repair and Pending for delivery after completing the Assign job
	    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Supervior authorization token
	    When Supervior After Count api request is made
	    Then response status code should be 200
	    And response body should be in JSON format
	    And response body should contain label "Pending for assignment" and count
	    And response body should contain label "Pending for repair" and count should be incremented by 1
	    And response body should contain label "Pending for delivery" and count
	    And response should be available in less than 1000 ms