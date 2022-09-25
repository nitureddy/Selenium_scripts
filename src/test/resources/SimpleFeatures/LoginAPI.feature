#authorName: Abhishek Yadav
#Keywords Summary : Login API 


Feature: Login API Feature #Bussiness Requirement
As a user of the application when I try to login using the right credentials the login api should generate a token.

	Scenario: Login API Scenario #TestCase
		User is making login api request using valid credentials
		  Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/userdetails" and authorization token
			And the Header should content-Type should be in "application/Json"
			And the request body should contain a json object with the credentials username and password
			When login api request is made #SEND 
			Then response status code should be 200
			And response body should be in JSON format
			And response body should contain message as "Success"
			And response body should contain a valid token
			And response should be available in less than 1000 ms