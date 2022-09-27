#Author: Abhishek Yadav
#Keywords Summary : Supervior User Details 


Feature: Supervior User Details API Feature
As a Supervior user of the application. I should be able to verify Supervior user details using Supervior authorization token.

  Scenario:  Supervior User Detail API Scenario
  	User will login into the application using Supervior login credentials and verify Supervior user details
	    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the Supervior authorization token
	    When Supervior User Detail GET api request is made
	    Then response statusCode should be 200
	    And response Body should be in Json
	    And response body should contain Message "Success"
	    And response body should contain Supervior login id "iamsup"
	    And response body should contain Supervior email id "john@gmail.com"
	    And response body should contain Supervior mobile number "9988778899"
	    And response should be not more than 1000 ms
   