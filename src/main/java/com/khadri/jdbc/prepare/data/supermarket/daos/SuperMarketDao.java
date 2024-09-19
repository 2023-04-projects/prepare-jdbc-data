package com.khadri.jdbc.prepare.data.supermarket.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketDao {

	public void insertSuperMarketData(SuperMarket market) {

		PreparedStatement pstmt;
		Statement createStatement;
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
			System.out.println("Exception Occured : " + e);
		} finally {
			JdbcConnectionUtil.closeResources();
		}

	}

	public void selectSuperMarketData() {
		try {

			Connection conn = JdbcConnectionUtil.getConnection();
			Statement createstament = conn.createStatement();
			ResultSet resultSet = createstament.executeQuery("select * from supermarket");

			while (resultSet.next()) {

				System.out.println("Cust_Name : " + resultSet.getString(1) + "Cust_Id : " + resultSet.getInt(2)
						+ "Cust_Price : " + resultSet.getDouble(3) + "Cust_Qty" + resultSet.getInt(4) + "Total_Amt : "
						+ resultSet.getDouble(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcConnectionUtil.closeResources();
		}

	}

}
