package com.khadri.jdbc.prepare.data.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileDao {

	PreparedStatement pstmt;
	Statement stmt;

	public void mobileInsertData(Mobile mobile) {

		System.out.println(" mobileInsertData : mobileInsertData(-) starts");

		try {
			Connection conn = JdbcConnectionUtil.getConnection();

			pstmt = conn.prepareStatement("insert into mobile values(?,?,?,?,?,?,?)");

			pstmt.setInt(1, mobile.getId());
			pstmt.setString(2, mobile.getName());
			pstmt.setInt(3, mobile.getRam());
			pstmt.setInt(4, mobile.getRom());
			pstmt.setString(5, mobile.getCamera());
			pstmt.setInt(6, mobile.getBattery());
			pstmt.setInt(7, mobile.getPrice());

		} catch (SQLException e) {
			System.out.println("mobileInsertData Exception occours:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();

			System.out.println("mobileInsertData : mobileInsertData(-) ends");

		}

	}

	public void mobileSelectData() {
		try {
			Connection conn = JdbcConnectionUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from mobile");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getInt(3) + "-"
						+ resultSet.getInt(4) + "-" + resultSet.getString(5) + "-" + resultSet.getInt(6) + "-"
						+ resultSet.getInt(7));
			}

		} catch (SQLException e) {
			System.out.println("MobileSelectDao SQLException occours:" + e);

			System.out.println(" MobileDao : mobileData(-) ends");

		}

	}

	public boolean MobileupdatetData(Mobile mobile) {
		System.out.println("Updating Mobile Record...!!!!");

		try {
			Connection conn = JdbcConnectionUtil.getConnection();
			System.out.println("MobileDao : updateMobileDao(-) starts");

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE mobile SET name = ?, ram = ?, rom = ?,camera = ?,battery = ?,price = ? WHERE id = ?");

			pstmt.setInt(1, mobile.getId());
			pstmt.setString(2, mobile.getName());
			pstmt.setInt(3, mobile.getRam());
			pstmt.setInt(4, mobile.getRom());
			pstmt.setString(5, mobile.getCamera());
			pstmt.setInt(6, mobile.getBattery());
			pstmt.setInt(7, mobile.getPrice());

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Update mobile record successfully" + rowsAffected);
		} catch (SQLException e) {
			System.out.println("MobileupdatetData SQLException Occurs:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();

			System.out.println("MobileDao : MobileupdatetData(-) ends");
		}
		return true;
	}

	public boolean MobileDeleteData(int id) {
		System.out.println("deleting Mobile Record...!!!!");

		try {
			Connection conn = JdbcConnectionUtil.getConnection();
			System.out.println("MobileDao : deleteMobileData(-) starts");

			PreparedStatement pstmt = conn.prepareStatement("Delete from mobile where id = ?");
			pstmt.setInt(1, id);

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("delete mobile record successfully" + rowsAffected);
		} catch (SQLException e) {
			System.out.println("(SQL Exception Occurs:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();

			System.out.println("MobileDao : deleteMobileData(-) ends");

		}
		return true;
	}

}
