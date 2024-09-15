package com.khadri.jdbc.prepare.data.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeInsertDao {
	public static void insertData(Employee emp) throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_jdbc", "root", "root");
			pstmt = con.prepareStatement("insert into Employee values(?,?,?,?)");

			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getDesigination());
			pstmt.setDouble(4, emp.getSalary());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception occours:" + e);

		}
	}
}
