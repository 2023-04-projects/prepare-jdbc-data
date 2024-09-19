package com.khadri.jdbc.prepare.data.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.jdbc.prepare.connection.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileInsertDao {

	public void insertData(Mobile mobile) {
		System.out.println(" MobileInsertDao : mobileInsertData(-) starts");

		PreparedStatement pstmt = null;

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

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("MobileInsertDao Exception occours:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();
			System.out.println(" MobileInsertDao :  mobileInsertData(-) ends");

		}
	}
}
