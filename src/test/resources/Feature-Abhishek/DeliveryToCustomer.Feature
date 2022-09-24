#Author: Abhishek Yadav
#Keywords Summary : Delivery To Customer


Feature: Delivery To Customer API Feature File
As a Delivery user of the application Delivery To Customer is done.


  Scenario:  Delivery To Customer API Scenario
    Given the endpoint and the Delivery authorization token
		And the contant-Type should be in "application/Json"
		And entering the job_number
    When Delivery To Customer api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message and data   
    And response body should contain message "Delivered to customer successfully"
    And response should be available in less than 1000 ms
   