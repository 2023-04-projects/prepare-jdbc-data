package com.khadri.jdbc.prepare.data.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketDao {

	Connection conn = JdbcConnectionUtil.getConnection();
	PreparedStatement pstmt;
	Statement stmt;

	public void insertSuperMarketData(SuperMarket market) {

		System.out.println("SuperMarketDao : superMarketInsertData(-) Starts");

		try {

			pstmt = conn.prepareStatement("INSERT INTO supermarket VALUES(?, ?, ?, ?, ?)");

			pstmt.setString(1, market.getProdName());
			pstmt.setInt(2, market.getProdId());
			pstmt.setDouble(3, market.getProdPrice());
			pstmt.setInt(4, market.getProdQty());
			pstmt.setDouble(5, market.getTotalAmt());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e);
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("SuperMarketDao : superMarketInsertData(-) ends");

		}

	}

	public void selectSuperMarketData() {
		System.out.println("SuperMarketDao : selectSuperMarketData(-) Starts");
		try {

			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM supermarket");

			while (resultSet.next()) {

				System.out.println("Cust_Name : " + resultSet.getString(1) + "Cust_Id : " + resultSet.getInt(2)
						+ "Cust_Price : " + resultSet.getDouble(3) + "Cust_Qty" + resultSet.getInt(4) + "Total_Amt : "
						+ resultSet.getDouble(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("SuperMarketDao : selectSuperMarketData(-) ends");
		}

	}

}
