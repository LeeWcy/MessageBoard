package DAO;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBConn {
	public static Connection conn;

	// Connection�������ӣ�
	// �������ݿ�
	public static Connection getConn() {
		try {
			// ����ע��SQLSever��JDBC����
			Class.forName("com.mysql.jdbc.Driver");
			// ��д�����ַ������������һ�ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MessageBoard","root","icanplay1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void CloseConn() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection conn=DBConn.getConn();
		if(conn!=null) {
			System.out.println("���ݿ���������");
		}else {
			System.out.println("���ݿ�����ʧ��");
		}
	}

}
