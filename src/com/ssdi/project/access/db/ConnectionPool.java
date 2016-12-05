package com.ssdi.project.access.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

	private static ConnectionPool connectPool = null;

	private ConnectionPool() {
	}

	public static synchronized ConnectionPool getInstance() {
		if (connectPool == null) {
			connectPool = new ConnectionPool();
		}
		return connectPool;
	}

	// mothod to open connection with the database
	public static Connection getConnection(boolean testDb) {

		String driver = "com.mysql.jdbc.Driver";
		String URL;
		String user;
		String pass;

		if (testDb) {

			URL = "jdbc:mysql://localhost:3306/hoteldb"; // connecting to
															// the
			// Database users
			user = "root";
			pass = "root";

		} else {

			URL = "jdbc:mysql://localhost:3306/hoteldb"; // connecting to
															// the
			// Database users
			user = "root";
			pass = "root";

		}

		/*
		 * String URL = "jdbc:mysql://localhost:3306/hoteldb"; // connecting to
		 * the // Database users String user = "root"; String pass = "root";
		 */

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, user, pass);
			return con;
		} catch (Exception e) {
			System.out.println(e);

		}
		return null;
	}

	public void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}