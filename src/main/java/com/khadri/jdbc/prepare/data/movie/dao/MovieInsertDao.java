package com.khadri.jdbc.prepare.data.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.movie.Movie;

public class MovieInsertDao {
	PreparedStatement pstmt = null;
	Statement stmt;

	public void movieInsertData(Movie movie) {
		System.out.println("MovieInsertDao : movieInsertData(-) starts");

		try {
			Connection con = JdbcConnectionUtil.getConnection();
			pstmt = con.prepareStatement("insert into movie values(?,?,?)");

			pstmt.setInt(1, movie.getMovieId());
			pstmt.setString(2, movie.getMovieName());
			pstmt.setDouble(3, movie.getMovieBudeget());

			pstmt.executeUpdate();

		} catch (SQLException exc) {
			System.out.println("MovieInsertDao Exception occours:" + exc);
		}
	}

	public void movieSelectData() {

		try {
			Connection con = JdbcConnectionUtil.getConnection();
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from movie");
			while (resultSet.next()) {
				System.out
						.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getDouble(3));
			}
		} catch (SQLException sqle) {
			System.out.println(" customerSelectDao SQLException occours" + sqle);

		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("MovieInsertDao : movieInsertData(-) ends");
		}
	}
}
