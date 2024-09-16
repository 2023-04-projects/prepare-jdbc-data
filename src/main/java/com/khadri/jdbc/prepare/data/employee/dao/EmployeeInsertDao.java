package com.khadri.jdbc.prepare.data.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeInsertDao {
	public static void insertData(Employee emp)  {
		PreparedStatement pstmt=null;

		try {   
			Connection con = JdbcConnectionUtil.getConnection();
			pstmt = con.prepareStatement("insert into Employee values(?,?,?,?)");

			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getDesigination());
			pstmt.setDouble(4, emp.getSalary());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception occours:" + e);

		}
		finally {
			   JdbcConnectionUtil.closeResources();  }
	}
}
