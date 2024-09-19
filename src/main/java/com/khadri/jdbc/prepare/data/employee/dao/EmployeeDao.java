package com.khadri.jdbc.prepare.data.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.employee.dao.model.Employee;

public class EmployeeDao {
	PreparedStatement pstmt=null;
	Statement stmt;
	public  void insertData(Employee emp)  {
		System.out.println("EmployeeDao : employeeData(-) starts");
		try {   
			Connection con = JdbcConnectionUtil.getConnection();
			pstmt = con.prepareStatement("insert into Employee values(?,?,?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getDesigination());
			pstmt.setDouble(4, emp.getSalary());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException occours:"+ e);
		}
		finally {
			   JdbcConnectionUtil.closeResources(); 
				System.out.println("EmployeeDao : employeeData(-) ends");
		}
	}
     public void employeeSelectData() {
    	 try {
    		 Connection con = JdbcConnectionUtil.getConnection();
    		stmt= con.createStatement();
    		 ResultSet resultSet = stmt.executeQuery("select * from Employee");
    		 while (resultSet.next()) {
    			 System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3) + "-"+resultSet.getDouble(4));
    		 }
    	 }catch(SQLException sqle){
    		 System.out.println(" EmployeeDao SQLException occurs");
    	 }finally {
    		 JdbcConnectionUtil.closeResources();
    	 }
     }
}
     

