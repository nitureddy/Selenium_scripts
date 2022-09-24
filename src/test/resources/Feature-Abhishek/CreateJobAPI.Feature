#Author: Abhishek Yadav
#Keywords Summary : Create New Job

Feature: Create Job API Feature File
As a FD user of the application verify that New Job is created.

Scenario: Create Job API Scenario
								 Given the endpoint and the authorization token
								 And the contant-Type should be in "application/Json"
								 And Customer and customer_address
								 And customer_product and problems
								 When the createjob api request is made
								 And the base url is "139.59.91.96:9000"
								 Then the response status code should be 200
								 And the response body should contain the message as "Job created successfully. "
								 And the response body should contain the job id
								 And the response body should contain the job_number
								 And the customer id should be created