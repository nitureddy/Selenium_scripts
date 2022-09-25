#Author: Abhishek Yadav
#Keywords Summary : Engineer User Details 


Feature: Engineer User Details API Feature
As a Engineer user of the application. I should be able to verify Engineer user details using Engineer authorization token.

  Scenario:  Engineer User Detail API Scenario
  	User will login into the application using engineer login credentials and verify Engineer user details
	   	Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the Engineer authorization token
	    When Engineer User Detail api request is made
	    Then response status code should be 200
	    And response body should be in JSON format
	    And response body should contain message "Success"
	    And response body should contain login_id "iameng"
	    And response body should contain email_id "email_id": "mark@gmail.com"
	    And response body should contain mobile_number "8899776655"
	    And response should be available in less than 1000 ms
   