/**
 * 
 */
package com.ui.pojo;

/**
 * @author Jatin
 *
 */
public class FDDashBoardTablePOJO {

	private String OEM;
	private String Job_Number;
	private String Imei;
	private String Product;
	private String Model;
	private String Warranty_Status;
	private String Action_Status;

	public FDDashBoardTablePOJO(String oEM, String job_Number, String imei, String product, String model,
			String warranty_Status, String action_Status) {
		super();
		OEM = oEM;
		Job_Number = job_Number;
		Imei = imei;
		Product = product;
		Model = model;
		Warranty_Status = warranty_Status;
		Action_Status = action_Status;
	}

	public String getOEM() {
		return OEM;
	}

	public void setOEM(String oEM) {
		OEM = oEM;
	}

	public String getJob_Number() {
		return Job_Number;
	}

	public void setJob_Number(String job_Number) {
		Job_Number = job_Number;
	}

	public String getImei() {
		return Imei;
	}

	public void setImei(String imei) {
		Imei = imei;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getWarranty_Status() {
		return Warranty_Status;
	}

	public void setWarranty_Status(String warranty_Status) {
		Warranty_Status = warranty_Status;
	}

	public String getAction_Status() {
		return Action_Status;
	}

	public void setAction_Status(String action_Status) {
		Action_Status = action_Status;
	}

	@Override
	public String toString() {
		return "FDDashBoardTablePOJO [OEM=" + OEM + ", Job_Number=" + Job_Number + ", Imei=" + Imei + ", Product="
				+ Product + ", Model=" + Model + ", Warranty_Status=" + Warranty_Status + ", Action_Status="
				+ Action_Status + "]";
	}


}
