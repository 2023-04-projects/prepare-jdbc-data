package com.khadri.jdbc.prepare.data.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.khadri.jdbc.data.dao.util.JdbcConnectionUtil;
import com.khadri.jdbc.prepare.data.mobile.dao.model.Mobile;

public class MobileInsertDao<mobile> {

	public static void insertData(Mobile mb) throws Exception {
		// write JDBC logic here
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Connection conn = JdbcConnectionUtil.getConnection();

			pstmt = con.prepareStatement("insert into mobile values(?,?,?,?,?,?,?)");

			pstmt.setInt(1, mb.getId());
			pstmt.setString(2, mb.getName());
			pstmt.setInt(3, mb.getRam());
			pstmt.setInt(4, mb.getRom());
			pstmt.setString(5, mb.getCamera());
			pstmt.setInt(6, mb.getBattery());
			pstmt.setInt(7, mb.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception occours:" + e);
		} finally {
			JdbcConnectionUtil.closeResources();
		}
	}
}
