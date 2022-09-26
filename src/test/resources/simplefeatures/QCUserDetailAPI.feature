#Author: Abhishek Yadav
#Keywords Summary : Quality Check User Details 


Feature: QC User Details API Feature
As a Quality Check user of the application. I should be able to verify Quality Check user details using Quality Check authorization token.

  Scenario:  QC User Detail API Scenario
  	User will login into the application using Quality Check login credentials and verify Quality Check user details
	    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/userdetails" and the QC authorization Token
	    When Quality Check User Detail GET api request is made
	    Then Response Statuscode should be 200
	    And response body should be in JSON Format
	    And response body contain message "Success"
	    And response body should contain Quality Check login_id "iamqc"
	    And response body should contain Quality Check email_id "mark@gmail.com"
	    And response body should contain Quality Check mobile number "8899776655"
	    And responseTime should be less than 1000 ms