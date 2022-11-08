package com.hostmm.hospital.common.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hostmm.hospital.database.connection.DBConnection;
import com.hostmm.hospital.utility.crypto.PasswordValidator;

public class LoginDAO {
	private Connection connection;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	
	public boolean isCredentialsValid(String username, String password, String role) throws SQLException {
		connection = DBConnection.getDBConnection();
		boolean signinOk = false;
		String storedPassword = null;
		try {
			pStmt = connection.prepareStatement("select username,password from " + role + " where username=?;");
			pStmt.setString(1, username);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				storedPassword = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		if (storedPassword != null)
			try {
				signinOk = PasswordValidator.validatePassword(password, storedPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return signinOk;
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
