#Author: Abhishek Yadav
#Keywords Summary : Before Count


Feature: Before Count API Feature
As a Quality Check user of the application. I should be able to get the count of Pending for QC, QC Completed and QC Rejected before the QC job is completed by the Quality Check using Quality Check authorization token.


  Scenario:  Before Count API Scenario
  	Quality Check user will login into the application and get the count of Pending for QC, QC Completed and QC Rejected before the QC job is completed
	    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Quality Check authorization token
	    When Before Count api request is made
	    Then response status code should be 200
	    And response body should be in JSON format
	    And response body should contain label "Pending for QC" and count
	    And response body should contain label "QC Completed" and count
	    And response body should contain label "QC Rejected" and count
	    And response should be available in less than 1000 ms