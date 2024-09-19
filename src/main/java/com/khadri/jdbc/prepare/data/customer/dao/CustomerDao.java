package com.khadri.jdbc.prepare.data.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.customer.dao.model.Customer;

public class CustomerDao {
	PreparedStatement pstmt = null;
	Statement stmt;
	public void insertData(Customer cust) {

		System.out.println("CustomerDao : customerData(-) starts");
		try {
			Connection con = JdbcConnectionUtil.getConnection();

			pstmt = con.prepareStatement("insert into customer values(?,?,?,?)");

			pstmt.setInt(1, cust.getId());
			pstmt.setString(2, cust.getName());
			pstmt.setString(3, cust.getAddress());
			pstmt.setLong(4, cust.getPhoneNum());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQLException occours:" + e);
		} 
	}
	
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
			System.out.println(" customerSelectData SQLException occours" + sqle);

		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}

}