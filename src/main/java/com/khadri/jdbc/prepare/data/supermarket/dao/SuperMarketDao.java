package com.khadri.jdbc.prepare.data.supermarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketDao {

	Connection conn = JdbcConnectionUtil.getConnection();
	PreparedStatement pstmt;
	Statement stmt;

	public int insertSuperMarketData(SuperMarket market) {
		int superMarketResult = 0;
		System.out.println("SuperMarketDao : insertSuperMarketData(-) Starts");
		try {

			pstmt = conn.prepareStatement("INSERT INTO supermarket VALUES(?, ?, ?, ?, ?)");

			pstmt.setString(1, market.getProdName());
			pstmt.setInt(2, market.getProdId());
			pstmt.setDouble(3, market.getProdPrice());
			pstmt.setInt(4, market.getProdQty());
			pstmt.setDouble(5, market.getTotalAmt());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("InsertSuperMarket SQLException Occured : " + e);
		}
		System.out.println("SuperMarketDao : insertSuperMarketData(-) ends");
		return superMarketResult;
	}

	public List<SuperMarket> selectSuperMarketData() {
		List<SuperMarket> superMarketResultList = new ArrayList<>();
		System.out.println("SuperMarketDao : selectSuperMarketData(-) Starts");
		try {

			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM supermarket");

			while (resultSet.next()) {

				superMarketResultList.add(new SuperMarket(resultSet.getString(1), resultSet.getInt(2),
						resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5)));
			}

		} catch (SQLException e) {
			System.out.println("SelectSuperMarket SQLException Occured : " + e);
		}
		System.out.println("SuperMarketDao : selectSuperMarketData(-) ends");
		return superMarketResultList;
	}

	public int updateSuperMarketData(SuperMarket market) {
		int result = 0;
		System.out.println("SuperMarketDao : updateSuperMarketData(-) Starts");

		try {
			pstmt = conn.prepareStatement(
					"UPDATE supermarket SET PROD_NAME = ?, PROD_PRICE = ?, PROD_QTY = ?, TOTAL_AMT = ? WHERE PROD_ID = ?");

			pstmt.setString(1, market.getProdName());
			pstmt.setDouble(2, market.getProdPrice());
			pstmt.setInt(3, market.getProdQty());
			pstmt.setDouble(4, market.getTotalAmt());
			pstmt.setInt(5, market.getProdId());

			int updateRecord = pstmt.executeUpdate();
			System.out.println(updateRecord + "Update SuperMarket Record ..!");

		} catch (SQLException e) {
			System.out.println("UpdateSuperMarket SQLException Occured : " + e);
		}
		System.out.println("SuperMarketDao : updateSuperMarketData(-) ends");

		return result;
	}

	public int deleteSuperMarketData(int prodId) {
		int result = 0;
		System.out.println("SuperMarketDao : deletedSuperMarketData(-) Starts");
		try {

			pstmt = conn.prepareStatement("DELETE FROM supermarket WHERE PROD_ID = ?");
			pstmt.setInt(1, prodId);

			int deleteRecord = pstmt.executeUpdate();
			System.out.println(deleteRecord + "Delete SuperMarket Record..!");
		} catch (SQLException e) {
			System.out.println("DeleteSuperMarket SQLException Occured : " + e);
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("SuperMarketDao : deleteSuperMarketData(-) ends");
		}
		return result ;
	}

}
