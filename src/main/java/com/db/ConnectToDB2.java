package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB2 {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = DBConnector.getConnection();
		Statement statement = con.createStatement();

		ResultSet result = statement.executeQuery("SELECT * from SR_DEV.mst_oem");
		// Query

		while (result.next()) {
			System.out.println(result.getString("name") + result.getString("code"));
		}
		// Result
		
		System.out.println(con);
		Connection con1 = DBConnector.getConnection();
		Connection con2 = DBConnector.getConnection();
		System.out.println(con1);
		System.out.println(con2);

	}

}
