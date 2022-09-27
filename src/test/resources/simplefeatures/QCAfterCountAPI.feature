#Author: Abhishek Yadav
#Keywords Summary : After Count


Feature: After Count API Feature
As a Quality Check user of the application. I should be able to get the count of Pending for QC, QC Completed and QC Rejected after the QC job is completed by the Quality Check using Quality Check authorization token.

  Scenario:  After Count API Scenario
  	Quality Check user will login into the application and get the count of Pending for QC, QC Completed and QC Rejected after the QC job is completed
	    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Quality Check authorization token
	    When Quality Check After Count GET api request is made
	    Then Response Status code should be 200
	    And response Body should be in JSON format
	    And response body should contain label "Pending for QC"
	    And response body should contain label Pending for QC count
	    And response body should contain Label "QC Completed"
	    And response body should contain label QC Completed count should be incremented by one
	    And response body should Label "QC Rejected"
	    And response body should contain label QC Rejected count
	    And the response time should be less than 1000 ms