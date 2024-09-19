package com.khadri.jdbc.prepare.data.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeInsertDao {
	public void insertData(Employee emp) {
		System.out.println("EmployeeInsertDao : employeeInsertData(-) Starts");
		PreparedStatement pstmt = null;

		try {
			Connection con = JdbcConnectionUtil.getConnection();
			pstmt = con.prepareStatement("insert into Employee values(?,?,?,?)");

			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getDesigination());
			pstmt.setDouble(4, emp.getSalary());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException occours:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();

			System.out.println("EmployeeInsertDao : employeeInsertData(-) ends");
		}
	}
}
