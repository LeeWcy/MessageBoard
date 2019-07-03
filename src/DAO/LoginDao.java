package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginDao {
	Connection conn = DBConn.getConn();
	// ���ݿ����Ӷ���
	PreparedStatement pstmt;

	public Login checkLogin(String name, String password) {
		// ��֤�û�������
		try {
			pstmt = conn.prepareStatement("select* from logins where name=?and password=?");
			pstmt.setString(1, name);
			// ����SQL������
			pstmt.setString(2, password);
			// ����SQL������
			ResultSet rs = pstmt.executeQuery();
			// ִ�в�ѯ�����ؽ����
			if (rs.next()) {
				// ͨ��JavaBean����ֵ
				Login login = new Login();
				login.setId(rs.getInt(1));
				login.setName(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setRole(rs.getInt(4));
				System.out.println("��¼�ɹ�");
				return login;
				// ����JavaBean����
			}
			System.out.println("��¼ʧ��");
			return null;
			// ��֤ʧ�ܷ���null
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<MessBor> findMbInfo(String st) {
		try {
			ArrayList<MessBor> al = new ArrayList<MessBor>();
			if(st==null) {
				pstmt = conn.prepareStatement("select * from messages");
			}
			else {
				pstmt = conn.prepareStatement("select * from messages where name=?");
				pstmt.setString(1, st);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MessBor mb = new MessBor();
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setTime(rs.getDate(3));
				mb.setTitle(rs.getString(4));
				mb.setMessage(rs.getString(5));
				al.add(mb);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<MessBor> findMbLikeInfo(String st) {
		try {
			ArrayList<MessBor> al = new ArrayList<MessBor>();
			pstmt = conn.prepareStatement("select * from messages where message like '%"+st+"%' ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MessBor mb = new MessBor();
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setTime(rs.getDate(3));
				mb.setTitle(rs.getString(4));
				mb.setMessage(rs.getString(5));
				al.add(mb);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getName(int id) {
		String name = null;
		try {
			pstmt = conn.prepareStatement("select name from logins where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
			}
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addInfo(MessBor mb) {
		try {
			pstmt = conn.prepareStatement("insert into messages values(?,?,?,?,?)");
			pstmt.setInt(1, mb.getId());
			pstmt.setString(2, mb.getName());
			pstmt.setDate(3, mb.getTime());
			pstmt.setString(4, mb.getTitle());
			pstmt.setString(5, mb.getMessage());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertUser(int id, String name, String password, Date time) {
		try {
			pstmt = conn.prepareStatement("insert into logins(id,name,password,role,time) values(?,?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setInt(4, 0);
			pstmt.setDate(5, time);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}