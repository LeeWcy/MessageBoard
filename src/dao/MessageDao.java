package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.LoginBean;
import bean.MessageBean;

public class MessageDao {
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs;
	private String sql;

	public List<MessageBean> getMessages() {
		List<MessageBean> messageList = new ArrayList<MessageBean>();
		try {
			con = DBconn.getConn();
			sql = "select * from message ORDER BY id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MessageBean mb = new MessageBean();
				mb.setID(rs.getInt("id"));
				mb.setName(rs.getString("Name"));
				mb.setMessageThem(rs.getString("MessageThem"));
				mb.setMessgaeTitle(rs.getString("MessageTitle"));
				mb.setMessageContent(rs.getString("MessageContent"));
				mb.setMessageReply(rs.getString("MessageReply"));
				mb.setDate1(rs.getString("udate"));
				mb.setReplyDate(rs.getString("replydate"));
				messageList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return messageList;
	}

	public int add(MessageBean messagebean) {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "insert into message(Name,MessageThem,MessageTitle,MessageContent,udate,account) "
					+ "value("
					+ "'"
					+ messagebean.getName()
					+ "'"
					+ ","
					+ "'"
					+ messagebean.getMessageThem()
					+ "'"
					+ ","
					+ "'"
					+ messagebean.getMessgaeTitle()
					+ "'"
					+ ","
					+ "'"
					+ messagebean.getMessageContent()
					+ "'"
					+ ","
					+ "'"
					+ messagebean.getDate1()
					+ "'"
					+ ","
					+ "'"
					+ messagebean.getAccount() + "'" + ")";
			pstmt = con.prepareStatement(sql);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return re;
	}

	public int delete(int id) {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "delete from message where id ='" + id + "'";
			pstmt = con.prepareStatement(sql);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return re;
	}

	public int updata(MessageBean messagebean, int id) {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "update message set MessageThem='"
					+ messagebean.getMessageThem() + "',MessageContent='"
					+ messagebean.getMessageContent() + "',MessageReply='"
					+ messagebean.getMessageReply() + "',udate='"
					+ messagebean.getDate1() + "',replydate='"
					+ messagebean.getReplyDate() + "',MessageTitle='"
					+ messagebean.getMessgaeTitle()+"' where id='" + id + "'";
			pstmt = con.prepareStatement(sql);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return re;
	}

	public int reply(MessageBean messagebean, int id) {
		int re = 0;
		try {
			con = DBconn.getConn();
			System.out.println(id);
			sql = "update message set MessageReply='"
					+ messagebean.getMessageReply() + "',replydate='"
					+ messagebean.getReplyDate() + "' where id='" + id + "'";
			//sql = "updata message set MessageReply='"+MessageReply+"',replydate='"+replydate+"' where id='"+id+"'";
			/*sql = "updata message set MessageReply=?,replydate=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,MessageReply);
			pstmt.setString(2,replydate);
			pstmt.setInt(3, id);
			//pstmt.setInt(3,id);
*/			pstmt=con.prepareStatement(sql);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return re;
	}

	public List<MessageBean> detailMessages(int MD) {
		List<MessageBean> messageList = new ArrayList<MessageBean>();
		try {
			con = DBconn.getConn();
			sql = "select * from message where id='" + MD + "' ORDER BY id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MessageBean mb = new MessageBean();
				mb.setID(rs.getInt("id"));
				mb.setName(rs.getString("Name"));
				mb.setMessageThem(rs.getString("MessageThem"));
				mb.setMessgaeTitle(rs.getString("MessageTitle"));
				mb.setMessageContent(rs.getString("MessageContent"));
				mb.setMessageReply(rs.getString("MessageReply"));
				mb.setDate1(rs.getString("udate"));
				mb.setReplyDate(rs.getString("replydate"));
				messageList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return messageList;
	}

	public List<MessageBean> FindByString(String keyword) {
		// TODO Auto-generated method stub
		List<MessageBean> messageList = new ArrayList<MessageBean>();
		try {
			con = DBconn.getConn();
			// sql = "select * from message where MessageTitle like %'" +
			// keyword
			// + "'% ";
			// +
			// "or Name like ? or MessageThem like ? or MessageContent like ? or MessageReply like ?  ";
			pstmt = con
					.prepareStatement("select * from message where MessageTitle like'%"
							+ keyword + "%'");
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				MessageBean mb = new MessageBean();
				mb.setID(rs.getInt("id"));
				mb.setName(rs.getString("Name"));
				mb.setMessageThem(rs.getString("MessageThem"));
				mb.setMessgaeTitle(rs.getString("MessageTitle"));
				mb.setMessageContent(rs.getString("MessageContent"));
				mb.setMessageReply(rs.getString("MessageReply"));
				mb.setDate1(rs.getString("udate"));
				mb.setReplyDate(rs.getString("replydate"));
				messageList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return messageList;
	}

	public int getCount() {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "select count(id) from message";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				re = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DBconn.closeResultSet(rs);
			// DBconn.closeStatement(pstmt);
			// DBconn.getConn();
		}
		return re;
	}

	public List<MessageBean> getMessagesByPage(int pageNo, int num) {
		List<MessageBean> messageList = new ArrayList<MessageBean>();
		try {
			int num1 = (pageNo - 1) * num;
			con = DBconn.getConn();
			// sql = "select * from message limit 0,3";
			pstmt = con.prepareStatement("SELECT * FROM message limit " + num1
					+ "," + num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MessageBean mb = new MessageBean();
				mb.setID(rs.getInt("id"));
				mb.setName(rs.getString("Name"));
				mb.setMessageThem(rs.getString("MessageThem"));
				mb.setMessgaeTitle(rs.getString("MessageTitle"));
				mb.setMessageContent(rs.getString("MessageContent"));
				mb.setMessageReply(rs.getString("MessageReply"));
				mb.setDate1(rs.getString("udate"));
				mb.setReplyDate(rs.getString("replydate"));
				messageList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DBconn.closeResultSet(rs);
			// DBconn.closeStatement(pstmt);
			// DBconn.getConn();
		}
		return messageList;
	}

	public LoginBean checklogin(String adminName, String password) {

		LoginBean login = new LoginBean();
		try {
			con = DBconn.getConn();
			pstmt = con
					.prepareStatement("select* from admin where adminName=? "
							+ " and adminPassword=?");
			pstmt.setString(1, adminName);
			pstmt.setString(2, password); 
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				login.setAdminName(rs.getString(1));
				login.setPassword(rs.getString(2));
				login.setAccount(rs.getString(4));
				login.setAuth(0);
				return login;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public LoginBean checkuserlogin(String account, String password) {

		LoginBean login = new LoginBean();
		try {
			con = DBconn.getConn();
			pstmt = con
					.prepareStatement("select* from user where account=? "
							+ " and password=?");
			pstmt.setString(1, account); 
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery(); 
			if (rs.next()) { 

				login.setAdminName(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setAccount(rs.getString(4));
				login.setAuth(1);

				return login;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public boolean insertUser(String account, String name, String password) {
		try {
			con = DBconn.getConn();
			pstmt = con.prepareStatement("insert into user(account,name,password) values(?,?,?)");
			pstmt.setString(1, account);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
