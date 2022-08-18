package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
		// Statement

		Statement statement = con.createStatement();

		ResultSet result = statement.executeQuery("SELECT * from SR_DEV.mst_oem");
		// Query

		while (result.next()) {
			System.out.println(result.getString("name") + result.getString("code"));
		}
		// Result
	}

}
