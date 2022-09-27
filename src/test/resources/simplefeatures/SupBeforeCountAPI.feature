#Author: Abhishek Yadav
#Keywords Summary : Before Count


Feature: Before Count API Feature
As a Supervior user of the application. I should be able to get the count of Pending for assignment, Pending for repair and Pending for delivery before the Assign job is completed by the Supervior using Supervior authorization token.



  Scenario:  Before Count API Scenario
  	Supervior user will login into the application and get the count of Pending for assignment, Pending for repair and Pending for delivery before completing the Assign job
	    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Sup authorization token 
	    When Supervior Before Count GET api request is made
	    Then Response statusCode should be 200
	    And response body should be in Json
	    And response body should contain label Pending for assignment "Pending for assignment"
	    And response body should contain label Pending for assignment count
	    And response Body contain label Pending for repair "Pending for repair"
	    And response body should contain label Pending for repair count
	    And response body should contain label Pending for delivery "Pending for delivery"
	    And response body should contain label Pending for delivery count
	    And ResponseTime should be less than 1000 ms