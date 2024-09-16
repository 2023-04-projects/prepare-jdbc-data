package com.khadri.jdbc.prepare.data.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.khadri.jdbc.data.dao.util.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.customer.dao.model.Customer;

public class CustomerInsertDao {
	public static void insertData(Customer cust) {
		PreparedStatement pstmt = null;

		try {
			Connection con = JdbcConnectionUtil.getConnection();

			pstmt = con.prepareStatement("insert into customer values(?,?,?,?)");

			pstmt.setInt(1, cust.getId());
			pstmt.setString(2, cust.getName());
			pstmt.setString(3, cust.getAddress());
			pstmt.setLong(4, cust.getPhone_Num());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException occours:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}
}
