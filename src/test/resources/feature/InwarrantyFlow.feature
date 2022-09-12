#Author: jatin@testautomationacademy.com
#Keywords Summary :

@e2etest @sanitytest @smoketest
Feature: Inwarranty flow of the application via backend
 As a user I want to verify if the inwarranty flow for google devices
 the backend works properly or not.

  Scenario: Inwarranty Flow for Google Devices via backend
   Given the customer  and product information
   When the fd logins
   And creates the inwarranty job for the customer 
   Then jobid is present in the response
   And job is in pending for assignment stage
   When supvisor logs in 
   And supvisor should assign the job to the engineer
   Then the job status should change to Pending For Repair
   


