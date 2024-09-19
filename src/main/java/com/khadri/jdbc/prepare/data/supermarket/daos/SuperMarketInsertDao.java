package com.khadri.jdbc.prepare.data.supermarket.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketInsertDao {

	public static void insertSuperMarketData(SuperMarket market) {

		PreparedStatement pstmt = null;
		try {
			Connection conn = JdbcConnectionUtil.getConnection();

			pstmt = conn.prepareStatement("INSERT INTO supermarket VALUES(?, ?, ?, ?, ?)");

			pstmt.setString(1, market.getProdName());
			pstmt.setInt(2, market.getProdId());
			pstmt.setDouble(3, market.getProdPrice());
			pstmt.setInt(4, market.getProdQty());
			pstmt.setDouble(5, market.getTotalAmt());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SuperMarKetInsertException Occured : " + e);
		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}

	public void selecttSuperMarketData(SuperMarket market) {
		try {
			Connection conn = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("Select * from superMarket");
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				
				System.out.println("Cust_Name : " + resultset.getString(1) 
				+ "Cust_Id : " + resultset.getInt(2) + "Cust_Price : " + resultset.getDouble(3)
				+ "Cust_Qty" + resultset.getInt(4) + "Total_Amt : " + resultset.getDouble(5));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}
}




/*
 * if()
 * ResultSet resultSet = stmt.getResultSet();
while (resultSet.next()) {
System.out.println(resultSet.getString(1));
}

*/
