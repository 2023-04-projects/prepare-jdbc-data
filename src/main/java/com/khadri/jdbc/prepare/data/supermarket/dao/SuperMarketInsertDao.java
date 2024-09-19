package com.khadri.jdbc.prepare.data.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketInsertDao {

	public void insertSuperMarketData(SuperMarket market) {
		System.out.println("SuperMarketInsertDao : superMarketInsertData(-) Starts");

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
			System.out.println("Exception Occured : " + e);
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("SuperMarketInsertDao : superMarketInsertData(-) ends");

		}

	}

}
