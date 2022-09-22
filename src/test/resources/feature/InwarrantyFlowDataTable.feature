#Author: jatin@testautomationacademy.com
#Keywords Summary :

@e2etest @sanitytest @smoketest
Feature: Inwarranty flow of the application via backend with testData
 As a user I want to verify if the inwarranty flow for google devices

Background:
Given the fd logs in to portal using the credentials "iamfd" and "password"
Then the response should have status code as 200


Scenario: Login API Scenario
Then the response should have status code as 200
And  token is generated with message as "success"


Scenario: Create Job API Scenario
When token is passed to createjob end
Then a job id should be created 


Scenario: Search for a job scenario
When token is passed to search end point  along with job number 14335
Then a job details should be shown 

