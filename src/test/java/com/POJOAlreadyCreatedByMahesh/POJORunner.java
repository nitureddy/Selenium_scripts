package com.POJOAlreadyCreatedByMahesh;

import com.google.gson.Gson;

public class POJORunner {

	public static void main(String[] args) {
		Customer c1 = new Customer("Mahesh", "Lname", "8909890989", "8908909090", "an@gmail.com", "fd@gf.com");
		CustomerAddress ca = new CustomerAddress("A101", "Apt", "Gandhi Rd", "Nakane", "Deopur", "345678", "IND", "MH");
		CustomerProduct cp = new CustomerProduct("03/02/22", "12345678901234", "12345678908909", "12345678908909", "URL", "P12345", "modelid");
		Problems problem[] = new Problems[2];
		problem[0] = new Problems(1, "Problem1");
		problem[1] = new Problems(2, "Problem2");
		
		CreatejobPOJO pojo = new CreatejobPOJO(1, 2, 3, 4, c1, ca, cp, problem);
		
		System.out.println(pojo); 			// entire details of POJO class(toString details) 
		System.out.println("Last Name of Customer :: "+pojo.getCustomer().getLast_name()); 		 	// print only Lname from customer class
		System.out.println("Problem number 1 :: "+pojo.problem[0]);  								
		System.out.println("Problem number 1 :: "+pojo.problem[1].getRemark());    					// print the remarks of problem 1
		System.out.println("******Create new object of Customer and set the value*******");
		Customer c2 = new Customer("Sing", "King", "mobilenumber", "mobile_number_alt", "email_id", "email_id_alt");
		pojo.setCustomer(c2); 
		System.out.println(pojo.getCustomer());  			// print the customer details
		System.out.println("********************** Eng Job Repair *********************");
		EngJobRepair engjobr = new EngJobRepair(10, problem);
		System.out.println(engjobr);  						
		System.out.println(engjobr.getJob_id());			// print the jobid
		System.out.println(engjobr.problems[0].getId());     	
		System.out.println(engjobr.problems[1].getRemark());	// print the remark of 1st index of problem
		System.out.println("******************** FD Login *****************");
		FDLoginPOJO fdLogin = new FDLoginPOJO("iamfd", "password");
		System.out.println(fdLogin);
		System.out.println("******************** Sup Login *****************");
		SupLoginPOJO supLogin = new SupLoginPOJO("iamsup", "password");
		System.out.println(supLogin);
		System.out.println("******************** Sup Assign Eng *****************");
		SupAssignEngPOJO supAssignEng = new SupAssignEngPOJO(10, 100);
		System.out.println(supAssignEng);
		System.out.println("******************** Eng Login *****************");
		EngLoginPOJO engLogin = new EngLoginPOJO("iameng", "password");
		System.out.println(engLogin);
		System.out.println("********************** Eng Job Repair *********************");
		EngJobRepair engjobr1 = new EngJobRepair(10, problem);
		System.out.println(engjobr1);  						
		System.out.println(engjobr1.getJob_id());			// print the jobid
		System.out.println(engjobr1.problems[0].getId());     	
		System.out.println(engjobr1.problems[1].getRemark());	// print the remark of 1st index of problem
		System.out.println("******************** QC Login *****************");
		QCLoginPOJO qcLogin = new QCLoginPOJO("iamqc", "password");
		System.out.println(qcLogin);
		System.out.println("******************** QC Pass Flow *****************");
		QCPassFlow qcPass = new QCPassFlow(20);
		System.out.println(qcPass);
		System.out.println("******************** QC Reject Flow *****************");
		QCRejectFlow qcReject = new QCRejectFlow(50);
		System.out.println(qcReject);
		System.out.println("******************** Deliver to Customer Flow *****************");
		DeliverToCustomerFlow deliverrToCust = new DeliverToCustomerFlow(25);
		System.out.println(deliverrToCust);
		System.out.println("############################### Use of gson Library for JSON Object Creation ###########################");
		System.out.println("********* FD Login JSON ********");
		Gson fdLoginJson = new Gson();
		String FDLoginRequest = fdLoginJson.toJson(fdLogin);  // creteJob JSON
		System.out.println(FDLoginRequest);
		System.out.println("********* Create job JSON ********");
		Gson createJob = new Gson();
		String requestAPI = createJob.toJson(pojo);  // creteJob JSON
		System.out.println(requestAPI);
		System.out.println("********* Job Repair JSON ********");
		Gson gsonRepairJob = new Gson();
		String repairJobJSON = gsonRepairJob.toJson(engjobr1);    
		System.out.println(repairJobJSON);
		System.out.println("********* Sup Login JSON ********");
		Gson supLoginJson = new Gson();
		String requestAPISupLogin = supLoginJson.toJson(supLogin);  
		System.out.println(requestAPISupLogin);
		System.out.println("******************** Sup Assign Eng JSON *****************");
		Gson supAssignJson = new Gson();
		String requestAPISupAssign = supAssignJson.toJson(supAssignEng);  
		System.out.println(requestAPISupAssign);
		System.out.println("******************** Eng Login JSON*****************");
		Gson engLoginJson = new Gson();
		String requestAPIEngLogin = engLoginJson.toJson(engLogin);  
		System.out.println(requestAPIEngLogin);
		System.out.println("******************** QC Login JSON*****************");
		Gson qcLoginJson = new Gson();
		String requestAPIQcLogin = qcLoginJson.toJson(qcLogin);  
		System.out.println(requestAPIQcLogin);
		System.out.println("******************** QC Pass Flow JSON*****************");
		Gson qcPassJson = new Gson();
		String requestAPIQCPass = qcPassJson.toJson(qcPass);  
		System.out.println(requestAPIQCPass);
		System.out.println("******************** QC Reject Flow JSON*****************");
		Gson qcRejectJson = new Gson();
		String requestAPIQCReject = qcRejectJson.toJson(qcReject);  
		System.out.println(requestAPIQCReject);
		System.out.println("******************** Deliver to Customer Flow JSON*****************");
		Gson deliverToCustJson = new Gson();
		String requestAPIDeliverToCust = deliverToCustJson.toJson(deliverrToCust);  
		System.out.println(requestAPIDeliverToCust);
	}

}
