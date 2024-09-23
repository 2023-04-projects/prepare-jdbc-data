package com.khadri.jdbc.prepare.data.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeDao {
	PreparedStatement pstmt;
	Statement stmt;
	Connection con=null;

	public void insertEmployeeData(Employee emp) {
		System.out.println("EmployeeDao : employeeData(-) starts");
		try {
			Connection con=JdbcConnectionUtil.getConnection();
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
			System.out.println("EmployeeDao : employeeData(-) ends");
		}
	}

	public void selectEmployeeData() {
		try {
			Connection con=JdbcConnectionUtil.getConnection();
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from Employee");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3)
						+ "-" + resultSet.getDouble(4));
			}
		} catch (SQLException sqle) {
			System.out.println(" EmployeeDao SQLException occurs");
		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}

	public boolean employeeUpdateData(Employee emp) {
 	    System.out.println("EmployeeDao : employeeUpdateData(-) starts");
 	    try {
 	    	 con=JdbcConnectionUtil.getConnection();
 	    	PreparedStatement  pstmt = con.prepareStatement("UPDATE employee SET name = ?, desigination = ?, salary = ? WHERE id = ?");
 			pstmt.setString(1, emp.getName());
 			pstmt.setString(2, emp.getDesigination());
 			pstmt.setDouble(3, emp.getSalary());
 			pstmt.setInt(4, emp.getId());

 	        int rowsAffected = pstmt.executeUpdate();
 	        System.out.println( "Rows affected: " + rowsAffected);
 	    
 	    } catch (SQLException e) {
 	        System.out.println("SQLException occurs in employeeUpdateData: " + e);
 	    } finally {
 	        JdbcConnectionUtil.closeResources();
 	        System.out.println("EmployeeDao : employeeUpdateData(-) ends");
 	}
 	    return true;
  }


	public boolean employeeDeleteData(int employeeId) {
    	    System.out.println("EmployeeDao : employeeDeleteData(-) starts");
    	    try {
    	    	Connection con=JdbcConnectionUtil.getConnection();
    	        pstmt = con.prepareStatement("delete from employee where id = ?");
    	        pstmt.setInt(1, employeeId);

    	        int rowsAffected = pstmt.executeUpdate();
    	        System.out.println("Rows affected: " + rowsAffected);

    	    } catch (SQLException e) {
    	        System.out.println("SQLException occurs in employeeDeleteData: " + e);
    	    } finally {
    	        JdbcConnectionUtil.closeResources();
    	        System.out.println("EmployeeDao : employeeDeleteData(-) ends");
    	}
    	    return true;
    	}
}