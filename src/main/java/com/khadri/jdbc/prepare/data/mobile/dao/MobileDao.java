package com.khadri.jdbc.prepare.data.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileDao {

	public void insertData(Mobile mobile) {
		System.out.println(" MobileDao : mobileData(-) starts");

		PreparedStatement pstmt;
		Statement stmt;

		try {
			Connection conn = JdbcConnectionUtil.getConnection();
			System.out.println("MobileDao : MobileDao(-) starts");

			pstmt = conn.prepareStatement("insert into mobile values(?,?,?,?,?,?,?)");

			pstmt.setInt(1, mobile.getId());
			pstmt.setString(2, mobile.getName());
			pstmt.setInt(3, mobile.getRam());
			pstmt.setInt(4, mobile.getRom());
			pstmt.setString(5, mobile.getCamera());
			pstmt.setInt(6, mobile.getBattery());
			pstmt.setInt(7, mobile.getPrice());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("MobileDao Exception occours:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();

			System.out.println("MobileDao : MobileDao(-) ends");

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
			System.out.println(" Exception occours:" + e);

			System.out.println(" MobileDao :  mobileData(-) ends");

		}

	}

	public boolean updateMobileData(Mobile mobile) {
		System.out.println("Updating mobile Record....!!!");
		try {
			Connection conn = JdbcConnectionUtil.getConnection();
			System.out.println("MobileDao : UpdateMobileDao(-) starts");
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE mobile SET MOBILE_NAME = ?,RAM = ?,ROM = ?,CAMERA = ?, BATTERY_CAPACITY = ?,PRICE = ? where MOBILE_ID = ? ");

			pstmt.setString(2, mobile.getName());
			pstmt.setInt(3, mobile.getRam());
			pstmt.setInt(4, mobile.getRom());
			pstmt.setString(5, mobile.getCamera());
			pstmt.setInt(6, mobile.getBattery());
			pstmt.setInt(7, mobile.getPrice());
			pstmt.setInt(1, mobile.getId());

			int rowAffected = pstmt.executeUpdate();
			System.out.println("Update Mobile record Successfully" + rowAffected);

		} catch (SQLException e) {
			System.out.println("MobileUpdateData SQLException occurs:" + e);

		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("MobileDao : UpdateMobileDao(-) ends");
		}
		return true;

	}

	public boolean deleteMobileData(int id) {
		System.out.println("Deleting Mobile Record...!!!");

		try {
			Connection conn = JdbcConnectionUtil.getConnection();
			System.out.println("MobileDao : DeleteMobileDao(-) starts");
			PreparedStatement pstmt = conn.prepareStatement("delete from mobile where MOBILE_ID = ?");
			pstmt.setInt(1, id);
			int rowAffected = pstmt.executeUpdate();
			System.out.println("delete Mobile record Successfully" + rowAffected);

		} catch (SQLException e) {
			System.out.println("MobileDeleteData SQLException occurs:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println("MobileDao : DeleteMobileDao(-) ends");
		}
		return true;
	}

}
