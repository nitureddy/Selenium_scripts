#Author: Abhishek Yadav
#Keywords Summary : Delivery To Customer


Feature: Delivery To Customer API Feature
As a Delivery user of the application. I should be able to Deliver the product to the Customer using the job number and authorization token.


 	Scenario:  Delivery To Customer API Scenario
   	Delivery will login into the application and Deliver the product to the Customer using the job number 
		 Given the Base URL is "139.59.91.96:9000" and the endpoint is "/v1/fd/delivertocustomer" and the Delivery authorization token
		 And  the Header should content-Type should be in "application/Json"
		 And the request body should contain a json object with job number
		 When Delivery To Customer api request is made
		 Then response status code should be 200
		 And response body should be in JSON format
		 And response body should contain message and data   
		 And response body should contain message "Delivered to customer successfully"
		 And response should be available in less than 1000 ms