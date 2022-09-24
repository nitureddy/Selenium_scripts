#Author: Abhishek Yadav
#Keywords Summary : Before Count


Feature: Before Count API Feature
As a FrontDesk user of the application. I should be able to get the count of Pending for delivery, Created today and Pending for FST assignment before the New Job is Created by the FrontDesk using FrontDesk authorization token.


  Scenario:  Before Count API Scenario
    Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the FrontDesk authorization token
    When Before Count api request is made
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain label "Pending for delivery", count
    And response body should contain label "Created today", count
    And response body should contain label "Pending for FST assignment", count
    And response should be available in less than 1000 ms