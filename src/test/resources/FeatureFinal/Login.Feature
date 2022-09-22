#Author: jatin@taa.com
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
@smoke @sanity
Feature: Verify if Login Feature is working
 As a user of the application, I should be able to login into the app using different user roles
 

  Scenario: Login Scenario via API
		Given the User credentials for the application
		| userName	| password |
		| iamfd 		|password |
		| iamsup 		|password |
		| iameng 		|password |
		| iamqc 		|password |
		
		When the user details are passed to the login api in JSON format
		Then the response status code should be 200
		And the response body should contain message as "Success"
		And a 40 characted token should be generated
		
		
 