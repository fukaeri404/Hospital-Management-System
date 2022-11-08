package com.hostmm.hospital.admin.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hostmm.hospital.database.connection.DBConnection;

public class AdminDAO {
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;

	private String adminID;

	public int getRowCount() {
		connection = DBConnection.getDBConnection();
		int rowNumbers = 0;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select count(*) from admin;");
			while (rs.next()) {
				rowNumbers = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowNumbers;
	}

	public String generateAdminID() {
		int rowNumbers = getRowCount() + 1;
		if (rowNumbers < 10)
			adminID = "Admin-000" + rowNumbers;
		else if (rowNumbers >= 10 && rowNumbers <= 99)
			adminID = "Admin-00" + rowNumbers;
		return adminID;

	}

	public int createAdmin(Admin admin) {
		connection = DBConnection.getDBConnection();
		int rowEffected = 0;
		try {
			pStmt = connection.prepareStatement(
					"INSERT INTO `hospitalmanagedb`.`admin` (`adminID`, `username`, `password`, `name`, `age`, `nrc`, `phone`, `address`, `gender`, `birthDate`, `salary`, `startDate`,  `role`, `imageName`,  `isActive`,`isSenior`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);");
			pStmt.setString(1, admin.getAdminID());
			pStmt.setString(2, admin.getUsername());
			pStmt.setString(3, admin.getPassword());
			pStmt.setString(4, admin.getName());
			pStmt.setInt(5, admin.getAge());
			pStmt.setString(6, admin.getNrc());
			pStmt.setString(7, admin.getPhone());
			pStmt.setString(8, admin.getAddress());
			pStmt.setString(9, admin.getGender());
			Date birthDate = Date.valueOf(admin.getBirthDate());
			pStmt.setDate(10, birthDate);
			pStmt.setDouble(11, admin.getSalary());
			Date startDate = Date.valueOf(admin.getStartDate());
			pStmt.setDate(12, startDate);
			pStmt.setString(13, admin.getRole());
			pStmt.setString(14, admin.getImageName());
			pStmt.setBoolean(15, admin.isActive());
			pStmt.setBoolean(16, admin.isSenior());
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowEffected;
	}

	public Admin getAdmin(String columnName, String value) {
		Admin admin = null;
		connection = DBConnection.getDBConnection();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from admin where" + columnName + " = '" + value + "';");
			while (rs.next()) {
				admin = new Admin(rs.getString("adminID"), rs.getString("username"), rs.getString("password"),
						rs.getString("name"), rs.getInt("age"), rs.getString("nrc"), rs.getString("phone"),
						rs.getString("address"), rs.getString("gender"), rs.getDate("birthDate").toLocalDate(),
						rs.getDouble("salary"), rs.getDate("startDate").toLocalDate(),
						rs.getDate("resignDate").toLocalDate(), rs.getString("role"), rs.getString("imageName"),
						rs.getBoolean("isActive"), rs.getBoolean("isSenior"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}

	private void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
