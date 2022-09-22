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
@tag
Feature: Create Job API Feature
  As a user of the application. when a fd users logs in to the portal they should be able to create the job

Background: 
 Given the user has logged into the application usind the credentials "iamfd" and "password" and the token is generated

 
 Scenario: Create Job Scenario
 Given the endpoint and the authorization token
 And Customer and Product Information
 When the createjob api request is made 
 Then the response status code should be 200
 And the response body should contain the message as "Job created successfully. "
 And the response body should contain the job id
 And the customer id should be created
 
 