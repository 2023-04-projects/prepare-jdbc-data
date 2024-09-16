package com.khadri.jdbc.data.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {

	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_jdbc", "root", "root");
		} catch (SQLException sql) {
			System.out.println("Exception " + sql);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Exception " + cnfe);
		}
		return con;
	}

	public static void closeResources() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		}
	}
}
