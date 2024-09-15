package com.khadri.jdbc.prepare.data.supermarket.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.supermarket.dao.model.SuperMarket;

public class SuperMarketInsertDao {

	public void insertSuperMarketData(SuperMarket market) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:MYSQL://localhost:3306/jdbc_test", "root", "ruhi@9022");
			pstmt = connection.prepareStatement("INSERT INTO supermarket VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, market.getProdName());
			pstmt.setInt(2, market.getProdId());
			pstmt.setDouble(3, market.getProdPrice());
			pstmt.setInt(4, market.getProdQty());
			pstmt.setDouble(5, market.getTotalAmt());

			int count = pstmt.executeUpdate();
			System.out.println(count + "INSERTED RECORDS SUCCESSFULLY ..!");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception Occured : " + e);
		}

	}

}
