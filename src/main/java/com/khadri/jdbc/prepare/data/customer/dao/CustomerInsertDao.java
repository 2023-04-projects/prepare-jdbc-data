package com.khadri.jdbc.prepare.data.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.customer.dao.model.Customer;

public class CustomerInsertDao {
	public static void insertData(Customer cust) throws Exception {
		// write JDBC logic here
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt =null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_jdbc", "root", "root");
			pstmt = con.prepareStatement("insert into customer values(?,?,?,?)");

			
			
			pstmt.setInt(1, cust.getId());
			pstmt.setString(2, cust.getName());
			pstmt.setString(3, cust.getAddress());
			pstmt.setLong(4, cust.getPhone_num());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception occours:"+e);
		} finally {

			//sc.close();
			//con.close();
		}
	}
}
