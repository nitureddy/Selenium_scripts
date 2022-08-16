Feature:Login Feature
		Verify if the user FD/SUP are able to login	

Scenario: Login API should allow valid user to login
Given Username is iamFd and password is password
When the user logs in
Then the response should be a valid token and the status code should be 200