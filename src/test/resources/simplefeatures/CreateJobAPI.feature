#Author: Abhishek Yadav
#Keywords Summary : Create New Job
Feature: Create Job API Feature
  As a FrontDesk user of the application. I should be able to create a new Job using Customer and customer_address and customer_product and problems.

  Scenario: Create Job API Scenario
    FrontDesk user will create a new Job using Customer and customer_address and customer_product and problems.

    Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/job/create" and the FD Authorization token
    And the Header should content-type should be "application/Json"
    And the request body should contain a json object with Customer, customer address, customer product and problems
    When the createjob POST api request is made
    Then Response Statuscode Should be 200 OK
    And the request body should contain a json object
    And the response body contain the message as "Job created successfully. "
    And the response body should contain the job id
    And the response body should contain the job_number
    And the customer id should be created
    And response should be available with in 1000 ms
