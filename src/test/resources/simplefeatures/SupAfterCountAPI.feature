#Author: Abhishek Yadav
#Keywords Summary : After Count


Feature: After Count API Feature
As a Supervior user of the application. I should be able to get the count of Pending for assignment, Pending for repair and Pending for delivery after the Assign job is completed by the Supervior using Supervior authorization token.


  Scenario:  After Count API Scenario
  	Supervior user will login into the application and get the count of Pending for assignment, Pending for repair and Pending for delivery after completing the Assign job
	    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Supervior Authorization token
	    When Supervior After Count GET api request is made
	    Then Response status Code should be 200
	    And response body Should be in Json
	    And response body contain label Pending for assignment "Pending for assignment"
	    And response body contain label Pending for assignment count
	    And response Body contain Label Pending for repair "Pending for repair"
	    And response body contain label Pending for repair count is incremented by one
	    And response body contain label Pending for delivery "Pending for delivery"
	    And response body contain label Pending for delivery count
	    And responsetime should be less than 1000 ms