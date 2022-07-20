package com.pojo;

public class Data {

	private int id;
	private String first_name;
	private String last_name;
	private String login_id;
	private String mobile_number;
	private String email_id;
	private String password;
	private String reset_password_date;
	private String lock_status;
	private String is_active;
	private String mst_role_id;
	private String mst_service_location_id;
	private String created_at;
	private String modified_at;
	private String role_name;
	private String service_location;

	public Data(int id, String first_name, String last_name, String login_id, String mobile_number, String email_id,
			String password, String reset_password_date, String lock_status, String is_active, String mst_role_id,
			String mst_service_location_id, String created_at, String modified_at, String role_name,
			String service_location) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.login_id = login_id;
		this.mobile_number = mobile_number;
		this.email_id = email_id;
		this.password = password;
		this.reset_password_date = reset_password_date;
		this.lock_status = lock_status;
		this.is_active = is_active;
		this.mst_role_id = mst_role_id;
		this.mst_service_location_id = mst_service_location_id;
		this.created_at = created_at;
		this.modified_at = modified_at;
		this.role_name = role_name;
		this.service_location = service_location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReset_password_date() {
		return reset_password_date;
	}

	public void setReset_password_date(String reset_password_date) {
		this.reset_password_date = reset_password_date;
	}

	public String getLock_status() {
		return lock_status;
	}

	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public String getMst_role_id() {
		return mst_role_id;
	}

	public void setMst_role_id(String mst_role_id) {
		this.mst_role_id = mst_role_id;
	}

	public String getMst_service_location_id() {
		return mst_service_location_id;
	}

	public void setMst_service_location_id(String mst_service_location_id) {
		this.mst_service_location_id = mst_service_location_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getModified_at() {
		return modified_at;
	}

	public void setModified_at(String modified_at) {
		this.modified_at = modified_at;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getService_location() {
		return service_location;
	}

	public void setService_location(String service_location) {
		this.service_location = service_location;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", login_id=" + login_id
				+ ", mobile_number=" + mobile_number + ", email_id=" + email_id + ", password=" + password
				+ ", reset_password_date=" + reset_password_date + ", lock_status=" + lock_status + ", is_active="
				+ is_active + ", mst_role_id=" + mst_role_id + ", mst_service_location_id=" + mst_service_location_id
				+ ", created_at=" + created_at + ", modified_at=" + modified_at + ", role_name=" + role_name
				+ ", service_location=" + service_location + "]";
	}

}
