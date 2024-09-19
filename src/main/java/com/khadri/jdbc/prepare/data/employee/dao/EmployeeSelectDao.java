package com.khadri.jdbc.prepare.data.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;

	public class EmployeeSelectDao {
			Statement stmt;
         public void employeeSelectData() {
        	 try {
        		 Connection con = JdbcConnectionUtil.getConnection();
        		 stmt = con.createStatement();
        		 ResultSet resultSet = stmt.executeQuery("select * from Employee");
        		 while (resultSet.next()) {
        			 System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3) + "-"+resultSet.getDouble(4));
        		 }
        	 }catch(SQLException sqle){
        		 System.out.println(" EmployeeSelectDao SQLException occurs");
        	 }finally {
        		 JdbcConnectionUtil.closeResources();
        	 }
         }
	}
         
		

	



