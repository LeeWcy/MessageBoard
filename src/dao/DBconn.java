package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconn {
	public static Connection conn;

	public static Connection getConn() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(

							"jdbc:mysql://localhost:3306/courseDesign","root", "icanplay1");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 鍏抽棴杩炴帴
	public static void CloseConn() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// 鍏抽棴缁撴灉闆�

	public static void closeStatement(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
