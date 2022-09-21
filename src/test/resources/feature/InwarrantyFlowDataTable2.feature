#Author: jatin@testautomationacademy.com
#Keywords Summary :

@e2etest @sanitytest @smoketest
Feature: Inwarranty flow of the application via backend with testData2
 As a user I want to verify if the inwarranty flow for google devices

  Scenario: FD login Scenario
  Given   user login  with valid credentials
  | username	| password |
  | iamfd	    | password |
  When user makes a login request
  Then response code should be 200
  And token value should not be null


