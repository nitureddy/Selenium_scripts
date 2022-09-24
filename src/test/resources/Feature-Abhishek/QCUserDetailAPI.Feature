#Author: Abhishek Yadav
#Keywords Summary : QC User Details 


Feature: QC User Details API Feature File
As a user of the application verify that I login as QC.


  Scenario:  QC User Detail API Scenario
    Given the endpoint and the QC authorization token
    When QC User Detail api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain message "Success"
    And response body should contain login_id "iamqc"
    And response body should contain email_id "email_id": "mark@gmail.com"
    And response body should contain mobile_number "8899776655"
