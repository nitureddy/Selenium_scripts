#Author: Abhishek Yadav
#Keywords Summary : FrontDesk User Details 


Feature: FrontDesk User Details API Feature
As a FrontDesk user of the application. I should be able to verify FrontDesk user details using FrontDesk authorization token.

  Scenario:  FrontDesk User Detail API Scenario
  	User will login into the application using FrontDesk login credentials and verify FrontDesk user details
	    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the FrontDesk authorization token
	    When FrontDesk User Detail GET api request is made
	    Then response body status code should be 200
	    And Response body should be in JSON format
	    And response body should contain message "Success"
	    And response body should contain login_id "iamfd"
	    And response body should contain email_id "mark@gmail.com"
	    And response body should contain mobile_number "8899776655"
	    And response should be less than 1000 ms
