#Author: jatin@testautomationacademy.com
#Keywords Summary :

@e2etest @sanitytest @smoketest
Feature: Inwarranty flow of the application via backend with testData
 As a user I want to verify if the inwarranty flow for google devices
 the backend works properly or not.

  Scenario:As a user of the application I should be able to create an inwarranty job
   Given the customer  and product information
   When the fd logins with userName as "iamfd" and password as "password"
   And creates the inwarranty job for the customer 
   Then jobid is present in the response
   And jobid should be a number
   And job is in pending for assignment stage
   And HTTP status code should be 200
   
   Scenario: As a user of the application supervisior should able to assign the job to engineer
   Given supvisor logs in with userName as "iamsup" and password as "password"
   And He should assign the job to the engineer
   Then the job status should change to Pending For Repair stage
   And HTTP status code should be 200
   
   
   Scenario: As a user of the application engineer should be able to mark the job complete with proper remark
   Given Engineer logs in with userName as "iameng" and password as "password"
   And He marks the job complete with proper remark as "issue resolved!"
   Then the job status should change to Pending For QC stage
   And HTTP status code should be 200
   


