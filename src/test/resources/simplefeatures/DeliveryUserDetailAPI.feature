#Author: Abhishek Yadav
#Keywords Summary : Delivery User Details 


Feature: Delivery User Details API Feature
As a Delivery user of the application. I should be able to verify Delivery user details using Delivery authorization token.

	Scenario:  Delivery User Detail API Scenario
   	User will login into the application Delivery login credentials and verify Delivery user details
	    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the Delivery authorization token
	    When Delivery User Detail api GET request is made
	    Then response StatusCode should be 200
	    And Response Body should be in JSON Format
	    And response body contain Message "Success"
	    And response body should contain Delivery user login_id "iamfd"
	    And response body should contain Delivery user email_id "mark@gmail.com"
	    And response body should contain Delivery user mobile_number "8899776655"
	    And response time should not be more than 1000 ms
