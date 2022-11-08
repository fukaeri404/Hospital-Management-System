package com.hostmm.hospital.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getDBConnection() {
		String url = "jdbc:mysql://localhost:3306/hospitalmanagedb?useSSL=false";
		String user = "root";
		String password = "1234";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}
}
