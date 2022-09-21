#Author: jatin@testautomationacademy.com
#Keywords Summary :

@e2etest @sanitytest @smoketest
Feature: Inwarranty flow of the application via backend with testData
 As a user I want to verify if the inwarranty flow for google devices

  Scenario: Login API Scenario
  Given  The user credentials
  |iamfd|password|
  |iamsup|password|
  |iamqc|password|
  |iameng|password|
 	When  login api request is made
 	Then the status code is 200



