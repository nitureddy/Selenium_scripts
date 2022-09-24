#Author: Abhishek Yadav
#Keywords Summary : Search Job

Feature: Search Job API Feature File
As a FD user of the application search New Job id.

Scenario: Create Job API Scenario
								 Given the endpoint and job_id
								 And the authorization token
								 And the contant-Type should be in "application/Json"
								 When Search api request is made
								 And the base url is "139.59.91.96:9000"
								 Then the response status code should be 200
								 And the response body should contain the message as "Success"
								 And the response body should contain the job id
								 And the response body should contain the job_number
								 And the response body should be mst_warrenty_status_code