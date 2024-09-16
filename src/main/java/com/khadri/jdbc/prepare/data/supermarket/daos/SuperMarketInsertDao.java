package com.khadri.jdbc.prepare.data.supermarket.daos;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.student.dao.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketInsertDao {

	public static void insertSuperMarketData(SuperMarket market) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		Connection con = null;
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
		}

	}

}
