#authorName: Abhishek Yadav

Feature: Login API Feature 
As a user of the application when I try to login using the right credentials the login api should generate a token.

	Scenario: Login API Scenario
		Given the user is entering the credentials "iamfd" and "password" and EndPoint
		And the contant-Type should be in "application/Json"
		When login api request is made
		And the base url is "139.59.91.96:9000"
		Then response status code should be 200
		And response body should be in JSON format
		And response body should contain message as "Success"
		And response body should contain a valid token
		And response should be available in less than 1000 ms