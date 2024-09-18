package com.khadri.jdbc.prepare.data.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.movie.Movie;

public class MovieInsertDao {
	public static void movieInsertData(Movie mo) throws Exception {
		PreparedStatement pstmt = null;

		try {
			Connection con = JdbcConnectionUtil.getConnection();
			pstmt = con.prepareStatement("insert into movie values(?,?,?)");

			pstmt.setInt(1, mo.getMovieId());
			pstmt.setString(2, mo.getMovieName());
			pstmt.setDouble(3, mo.getMovieBudeget());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception occours:" + e);
		}
	}
}
