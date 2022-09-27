#Author: Abhishek Yadav
#Keywords Summary : Before Count
Feature: Before Count API Feature
  As a FrontDesk user of the application. I should be able to get the count of Pending for delivery, Created today and Pending for FST assignment before the New Job is Created by the FrontDesk using FrontDesk authorization token.

  Scenario: Before Count API Scenario
    FrontDesk user will login into the application and get the count of Pending for delivery, Created today and Pending for FST assignment before New Job is Created
	    Given the BaseURL is "http://139.59.91.96:9000" and the endpoint is "/v1/dashboard/count" and the FrontDesk authorization token
	    When Before Count GET api request is made
	    Then response Status code should be 200
	    And the response body should be in JSON format
	    And response body contain label Pending for delivery
	    And response body should contain Pending for delivery count
	    And response body should contain label Create Today
	    And response body should contain Create count
	    And response body should contain label Pending for FST assignment
	    And response body should contain Pending for FST assignment count
	    And response time should be less than 1000 ms
