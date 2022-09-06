#Author: Jatin Shharma
#Keywords Summary : Login API Feature Test
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
Feature: Test Phoenix Backend Application
  In order to Test Phoenix Backend Application
  As a user 
  I should be able to login into the application by using api.

  @tag1
  Scenario: Verify User Login with API
  login to phoenix application using some valid credentials with the help of login api.
  	Given backend url and login endpoint
  	When a valid user enters their credentials
  	Then the reponse status code is 200
  	
