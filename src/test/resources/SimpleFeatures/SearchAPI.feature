#Author: Abhishek Yadav
#Keywords Summary : Search Job

Feature: Search Job API Feature
As a user of the application. I should search job using the right job_id and authorization token.


	Scenario: Search Job API Scenario
		User will login into the application using valid login credentials and search job using the right job_id
			 Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/job/search" and authorization token
       And the Header should content-Type should be in "application/Json"
       And the request body should contain a json object with the job id
			 When Search api request is made
			 Then the response status code should be 200
			 And the response body should contain the message as "Success"
			 And the response body should contain the job id
			 And the response body should contain the job_number
			 And the response body should be mst_warrenty_status_code
			 And response should be available in less than 1000 ms