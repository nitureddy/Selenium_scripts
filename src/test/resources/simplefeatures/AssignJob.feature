#Author: Abhishek Yadav
#Keywords Summary : Assign Job
Feature: Assign Job API Feature
  As a Supervior user of the application. I should be able to assign job to the Engineer using jobId and engineerId

  Scenario: Assign Job API Scenario
    Supervior will login into the application and assign the job to engineer

    Given the Base URL is "http://139.59.91.96:9000" endpoint is "/v1/engineer/assign" and the supervior authorization token
    And the Header should Content-Type should be in "application/Json"
    And the request body should contain a json object with jobId 14091 and engineer ID 2
    When Assign Jobs POST api request is made
    Then Response Status Code should be 200
    And response body should be in JSON FORMAT
    And response body contain Engineer message "Engineer assigned successfully"
    And responseTime Should be less than 1000 ms
