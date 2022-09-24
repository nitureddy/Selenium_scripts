#Author: Abhishek Yadav
#Keywords Summary : Before Count


Feature: Before Count API Feature File
As a Eng user of the application verify Before count.


  Scenario:  Before Count API Scenario
    Given the endpoint and the Eng authorization token
    When Before Count api request is made
    And the base url is "139.59.91.96:9000"
    Then response status code should be 200
    And response body should be in JSON format
    And response body should contain label "Pending for repair", count
    And response body should contain label "Repair completed", count