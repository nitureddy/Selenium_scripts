#Author: jatin@testautomationacademy.com
#Keywords Summary :

@e2etest @sanitytest @smoketest
Feature: Inwarranty flow of the application via backend with testData
 As a user I want to verify if the inwarranty flow for google devices

  Scenario: Create an Inwarranty job for google devices with data
  Given  user login  with username "iamfd" and password as "password"
  When create job api request is made with the customer info
  |raj|7045663552|
  Then the jobid should be created



