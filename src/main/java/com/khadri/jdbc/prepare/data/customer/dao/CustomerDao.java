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
	  Connection con;
	  
	public void insertCustomerData(Customer cust) {

		System.out.println("CustomerDao : customerData(-) starts");
		try {
		con = JdbcConnectionUtil.getConnection();

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
	
	public void selectCustomerData() {

		try {
			 con = JdbcConnectionUtil.getConnection();
			stmt = con.createStatement();

			ResultSet resultSet = stmt.executeQuery("Select * from customer");

			while (resultSet.next()) {
				
				System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3)
						+ " - " + resultSet.getLong(4));
			}
		} catch (SQLException sqle) {
			System.out.println(" selectCustomerData SQLException occours" + sqle);

		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("CustomerInsertDao : customerInsertData(-) ends");

		}
	}

	public boolean updateCustomerData(Customer cust) {
	    System.out.println("CustomerDao : updateCustomerData(-) starts");

	    try {
	      con = JdbcConnectionUtil.getConnection();

	        pstmt = con.prepareStatement("UPDATE customer SET name = ?, address = ?, phoneNum = ? WHERE id = ?");
	        
	        pstmt.setString(1, cust.getName());
	        pstmt.setString(2, cust.getAddress());
	        pstmt.setLong(3, cust.getPhoneNum());
	        pstmt.setInt(4, cust.getId());

	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println("Rows affected: " + rowsAffected);

	    } catch (SQLException e) {
	        System.out.println("SQLException occurs in updateCustomerData: " + e);
	    } finally {
	        JdbcConnectionUtil.closeResources();
	        System.out.println("CustomerDao : updateCustomerData(-) ends");
	    }
		return true;
	}
	
	public boolean deleteCustomerData(int customerId) {
	    System.out.println("CustomerDao : deleteCustomerData(-) starts");

	    try {
	        con = JdbcConnectionUtil.getConnection();

	        pstmt = con.prepareStatement("DELETE FROM customer WHERE id = ?");
	        pstmt.setInt(1, customerId);

	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println("Rows affected: " + rowsAffected);

	    } catch (SQLException e) {
	        System.out.println("SQLException occurs in deleteCustomerData: " + e);
	    } finally {
	        JdbcConnectionUtil.closeResources();
	        System.out.println("CustomerDao : deleteCustomerData(-) ends");
	    }
		return true;
	}
}