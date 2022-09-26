#Author: Abhishek Yadav
#Keywords Summary : Engineer User Details 


Feature: Engineer User Details API Feature
As a Engineer user of the application. I should be able to verify Engineer user details using Engineer authorization token.

  Scenario:  Engineer User Detail API Scenario
  	User will login into the application using engineer login credentials and verify Engineer user details
	   	Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the Engineer authorization token
	    When Engineer User Detail GET api request is made
	    Then response statuscode should be 200
	    And response body should be in JSON
	    And response Body should contain message "Success"
	    And response Body should contain login_id "iameng"
	    And response body should contain email id "mark@gmail.com"
	    And response Body should contain mobile_number "8899776655"
	    And response Should be less than 1000 ms
   