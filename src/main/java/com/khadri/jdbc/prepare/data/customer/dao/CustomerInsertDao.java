package com.khadri.jdbc.prepare.data.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.customer.dao.model.Customer;

public class CustomerInsertDao {
	public void insertData(Customer cust) {
		PreparedStatement pstmt = null;

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
		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}
}