#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@E2Eflow
Feature: Inwarranty Feature
As a user of the application I want to create an inwarranty Job
 
				Background: User should be logged into the application
										Given the BaseURL is "http://139.59.91.96:9000"
									 	And the user credentials are
									 	| userName	| password |
										| iamfd 		|password |
										| iamsup 		|password |
										| iameng 		|password |
										| iamqc 		|password |
										When the login api request is made
				 
				 
				Scenario: Login Scenario via API
											Then the response status code should be 200
											And the response body should contain message as "Success"
											And a 40 characted token should be generated
						
				Scenario: Create Job Scenario
								 Given the endpoint and the authorization token
								 And Customer and Product Information
								 When the createjob api request is made 
								 Then the response status code should be 200
								 And the response body should contain the message as "Job created successfully. "
								 And the response body should contain the job id
								 And the customer id should be created
								 
					Scenario: Calculate Count for Jobs Scenario
								 Given the endpoint and the authorization token
								 When the createjob api request is made 
								 Then the count for the job created today should be incremented by 1
								 
								 
				Scenario: Search Job Scenario
									Given the authorization token and the jobNumber 343412
									When the "job/details/343412" request	is made 
									Then response status code should be 200
									And response body should be a JSON Object
									And the response body should have message as "Success"
									And the data in the response body should contain jobid,job_number,tr_customer_id and problem details
				
					Scenario: Assign Job to the Engineer 
								 Given the job assignment endpoint, authorization token and engineer id is 2
								 When the assignjob api request is made 
								 Then the response status code should be 200
								 And the response body should contain the message as "Engineer assigned successfully "
								 
								 
			 		Scenario: Engineer works on the job
								 Given the jobnumber and remark is "Issue resolved"
								 When the repaircomplete api request is made 
								 Then the response status code should be 200
								 And the response body should contain the message as "Repair successful."
								 
								 			 
			 		Scenario: QC Accepts the JOB
								 Given the jobnumber in the requestbody
								 When the qc api request is made 
								 Then the response status code should be 200
								 And the response body should contain the message as "QC successful."
								 
								 
	 		 		Scenario: JOB is Delivered to the customer
								 Given the jobnumber and the fd token 
								 When the delivertocustomer api request is made 
								 Then the response status code should be 200
								 And the response body should contain the message as "Job closed successfully"