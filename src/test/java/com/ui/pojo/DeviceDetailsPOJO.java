/**
 * 
 */
package com.ui.pojo;

/**
 * @author Jatin
 *
 */
public class DeviceDetailsPOJO {
	private String oemName;
	private String prodName;
	private String modelName;
	private String imeiName;
	private String dop;
	private String warrantyStatus;

	public DeviceDetailsPOJO(String oemName, String prodName, String modelName, String imeiName, String dop,
			String warrantyStatus) {
		super();
		this.oemName = oemName;
		this.prodName = prodName;
		this.modelName = modelName;
		this.imeiName = imeiName;
		this.dop = dop;
		this.warrantyStatus = warrantyStatus;
	}

	public String getOemName() {
		return oemName;
	}

	public void setOemName(String oemName) {
		this.oemName = oemName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getImeiName() {
		return imeiName;
	}

	public void setImeiName(String imeiName) {
		this.imeiName = imeiName;
	}

	public String getDop() {
		return dop;
	}

	public void setDop(String dop) {
		this.dop = dop;
	}

	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}

	@Override
	public String toString() {
		return "DeviceDetailsPOJO [oemName=" + oemName + ", prodName=" + prodName + ", modelName=" + modelName
				+ ", imeiName=" + imeiName + ", dop=" + dop + ", warrantyStatus=" + warrantyStatus + "]";
	}

}
