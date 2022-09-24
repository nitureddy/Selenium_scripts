#Author: Abhishek Yadav
#Keywords Summary : After Count


Feature: After Count API Feature File
As a Sup user of the application verify After count.


  Scenario:  After Count API Scenario
    Given the endpoint and the Sup authorization token
    When After Count api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain label "Pending for assignment" and count
    And response body should contain label "Pending for repair" and count should be incremented by 1
    And response body should contain label "Pending for delivery" and count