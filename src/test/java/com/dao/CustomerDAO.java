package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO {
	private Connection con;

	public CustomerDAO() {
		con = DBConnector.getConnection();

	}

	public CustomerPOJO getCustomerInformationfFromDB(int custId) {
		Statement statement = null;
		ResultSet resultSet = null;
		CustomerPOJO customer = null;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("SELECT * from tr_customer where id = '" + custId + "'");
			while (resultSet.next()) {
		
				customer = new CustomerPOJO(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("mobile_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
}
