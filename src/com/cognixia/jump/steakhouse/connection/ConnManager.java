package com.cognixia.jump.steakhouse.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {

	private static Connection connection = null;

	private static void makeConnection() {

		Properties props = new Properties();

		try {
			props.load(new FileInputStream("resources/config.properties"));
			System.out.println("config.properties loaded.");
		} catch (IOException e) {
			System.out.println("Couldn't load .properties file");
			e.printStackTrace();
		}

		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");

		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("DB connection login passed.");
		} catch (SQLException e) {
			System.out.println("DB connection login failed");
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			makeConnection();
			if (connection != null) {
				System.out.println("getConnection made.");
			} else {
				System.out.println("getConnection failed. Still null.");
			}
		} else {
			System.out.println("getConnection wasn't null. No makeConnection attempt.");
		}
		return connection;
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = ConnManager.getConnection();
		if (connection != null) {
			System.out.println("main Connection made.");
		} else {
			System.out.println("main Connection failed.");
		}

		try {
			conn.close();
			System.out.println("Closed Connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
