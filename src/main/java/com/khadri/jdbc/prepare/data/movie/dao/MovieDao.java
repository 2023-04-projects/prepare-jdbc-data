package com.khadri.jdbc.prepare.data.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.movie.Movie;

public class MovieDao {
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
			ResultSet resultSet = stmt.executeQuery("select * from movie");
			while (resultSet.next()) {
				System.out
						.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getDouble(3));
			}
		} catch (SQLException sqle) {
			System.out.println(" MovieSelectDao SQLException occours" + sqle);

		}
	}

	public boolean movieUpdateData(Movie movie) {
		try {
			Connection connection = JdbcConnectionUtil.getConnection();
			pstmt = connection.prepareStatement("UPDATE movie SET  MovieName =?, MovieBudeget = ? WHERE  MovieId = ? ");

			pstmt.setString(1, movie.getMovieName());
			pstmt.setDouble(2, movie.getMovieBudeget());
			pstmt.setInt(3, movie.getMovieId());

			int executeUpdate = pstmt.executeUpdate();
			System.out.println("UPDATED ROWS IN TABLE" + executeUpdate);

		} catch (SQLException e) {
			System.out.println("MovieUpdateData SQLException Occours" + e);

		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("MovieUpdataDao : movieUpdateData(-) ends");
		}
		return true;

	}

	public boolean deleteMovieData(int movieId) {
		System.out.println("CustomerDao : deleteMovieData(-) starts");

		try {
			Connection con = JdbcConnectionUtil.getConnection();

			pstmt = con.prepareStatement("DELETE FROM movie WHERE MovieId = ?");
			pstmt.setInt(1, movieId);

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("SQLException occurs in deleteMoviesData: " + e);
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("movieDao : deleteMovieData(-) ends");
		}
		return true;
	}
}
