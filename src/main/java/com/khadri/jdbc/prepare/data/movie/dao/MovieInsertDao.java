package com.khadri.jdbc.prepare.data.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.movie.Movie;

public class MovieInsertDao {
	public void movieInsertData(Movie movie) throws Exception {
		System.out.println("MovieInsertDao : movieInsertData(-) starts");

		PreparedStatement pstmt = null;
		try {
			Connection con = JdbcConnectionUtil.getConnection();
			pstmt = con.prepareStatement("insert into movie values(?,?,?)");

			pstmt.setInt(1, movie.getMovieId());
			pstmt.setString(2, movie.getMovieName());
			pstmt.setDouble(3, movie.getMovieBudeget());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("MovieInsertDao Exception occours:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("MovieInsertDao : movieInsertData(-) ends");
		}
	}
}
