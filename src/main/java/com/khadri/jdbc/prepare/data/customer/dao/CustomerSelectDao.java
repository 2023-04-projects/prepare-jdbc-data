package com.khadri.jdbc.prepare.data.customer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;

public class CustomerSelectDao {
	Statement stmt;
	public void customerSelectData() {

		try {
			Connection con = JdbcConnectionUtil.getConnection();
			stmt = con.createStatement();

			ResultSet resultSet = stmt.executeQuery("Select * from customer");

			while (resultSet.next()) {
				
				System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3)
						+ " - " + resultSet.getLong(4));
			}
		} catch (SQLException sqle) {
			System.out.println(" customerSelectDao SQLException occours" + sqle);

		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}

}
