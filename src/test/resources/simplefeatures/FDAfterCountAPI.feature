#Author: Abhishek Yadav
#Keywords Summary : After Count
Feature: After Count API Feature
  As a FrontDesk user of the application. I should be able to get the count of Pending for delivery, Created today and Pending for FST assignment after New Job is Created by the FrontDesk using FrontDesk authorization token.

  Scenario: After Count API Scenario
    FrontDesk user will login into the application and get the count of Pending for delivery, Created today and Pending for FST assignment after New Job is Created

    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the FD authorization token
    When After Count GET api request is made
    Then Response status code should be 200
    And response body in JSON format
    And response body contain label pending for delivery
    And response body should contain Pending for Delivery count
    And response body should contain label create Today
    And response body should contain Create count hould be incremented by 1
    And response body should contain label pending for FST assignment
    And response body should contain Pending for FST Assignment count
    And Response time should be less than 1000 ms
