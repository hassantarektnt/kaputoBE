package com.services;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection = null;

	public static Connection getActiveConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/kaputo?"
							+ "user=root&password=1234&characterEncoding=utf8");
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); connection =
			 * DriverManager
			 * .getConnection("jdbc:mysql://127.11.21.130:3306/kaputo?" +
			 * "user=adminDpGxqEN&password=XJvaKtEZ3DKb&characterEncoding=utf8"
			 * );
			 */
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
