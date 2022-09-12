o#Author: your.email@your.domain.com
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
@SmokeTest @Sanity @E2ETest
Feature: InWarranty Flow
In order to test the Inwaranty Feature 
I should create inwarranty job from Front Desk
The supervisisor should assign the job to engineer
Enginer should work on the job and give it to QC for quality check
QC should pass the job and FD should return the job the custome.


Scenario: Inwarranty Flow
	Given the customer information and product details
	And FD logins into the system
	When FD creates the job with customer information 
	Then a jobID should be created
	When SUP logs into the system 
	Then job should be in pending for assignment
	And Sup should assign the job to the Engineer
	When Engineer logs into the system 
	Then job should be in pending for repair
	And Engineer works on the job
	And marks the job for QC
	Then job should be in pending for QC
	When QC completes the jon
	Then the job should be for pending for delivery
	
 
	
	