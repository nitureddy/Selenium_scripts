
Feature: Job Details API Feature
  As a user of the application. when a fd/sup/eng/qc users logs in to the portal they should be able to search the job

Background: 
 Given the user has logged into the application usind the credentials using
 	| userName	| password |
	| iamfd 		|password |
	| iamsup 		|password |
	| iameng 		|password |
	| iamqc 		|password |

Scenario: Search Job Scenario
Given the authorization token and the jobNumber 343412
When the "job/details/343412" request	is made 
Then response status code should be 200
And response body should be a JSON Object
And the response body should have message as "Success"
And the data in the response body should contain jobid,job_number,tr_customer_id and problem details