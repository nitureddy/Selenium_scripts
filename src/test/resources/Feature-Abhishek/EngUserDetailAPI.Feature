#Author: Abhishek Yadav
#Keywords Summary : Eng User Details 


Feature: Eng User Details API Feature File
As a user of the application verify that I login as Eng.


  Scenario:  Eng User Detail API Scenario
    Given the endpoint and the Sup authorization token
    When Eng User Detail api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message "Success"
    And response body should contain login_id "iameng"
    And response body should contain email_id "email_id": "mark@gmail.com"
    And response body should contain mobile_number "8899776655"
    And response should be available in less than 1000 ms
   