#Author: Abhishek Yadav
#Keywords Summary : Delivery To Customer


Feature: Delivery To Customer API Feature
As a Delivery user of the application. I should be able to Deliver the product to the Customer using the job number and authorization token.


 	Scenario:  Delivery To Customer API Scenario
   	Delivery will login into the application and Deliver the product to the Customer using the job number 
		 Given the Base URL is "http://139.59.91.96:9000" and the endpoint is "/v1/fd/delivertocustomer" and the Delivery Authorization token
		 And  the Header should Content-type should be in "application/Json"
		 And the request body should contain a json object with job number 15725
		 When Delivery To Customer POST api request is made
		 Then response statuscode Should be 200
		 And Response Body should be in JSON format  
		 And response body contain Delivered message "Delivered to customer successfully"
		 And response time should be available in less than 1000 ms