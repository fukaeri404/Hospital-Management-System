package com.hostmm.hospital.database.connection.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.hostmm.hospital.database.connection.DBConnection;

class DBConnectionTest {

	@Test
	void DBConnectionNotNullTest() {
		Connection connection = DBConnection.getDBConnection();
		assertNotNull(connection);
		System.out.println("Successfully connected to DB");
	}

}
