package com.khadri.jdbc.prepare.data.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.movie.Movie;

public class MovieInsertDao {
	public static void insertData(Movie mo) throws Exception {
		// write JDBC logic here
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch","root","Wellcome@123");
			pstmt = con.prepareStatement("insert into movie values(?,?,?)");

			// Set the parameters from the Customer object
			pstmt.setInt(1, mo.getMovieId());
			pstmt.setString(2, mo.getMovieName());
			pstmt.setDouble(3, mo.getMovieBudeget());

			// Execute the INSERT query and return the number of affected rows
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// return 0; // Return 0 if there is an exception
			System.out.println("Exception occours:" + e);
		}
	}
}
