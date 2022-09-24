#Author: Abhishek Yadav
#Keywords Summary : Before Count


Feature: Before Count API Feature
As a Supervior user of the application. I should be able to get the count of Pending for assignment, Pending for repair and Pending for delivery before the Assign job is completed by the Supervior using Supervior authorization token.



  Scenario:  Before Count API Scenario
    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the Supervior authorization token 
    When Before Count api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain label "Pending for assignment" and count
    And response body should contain label "Pending for repair" and count
    And response body should contain label "Pending for delivery" and count
    And response should be available in less than 1000 ms