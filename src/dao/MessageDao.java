package dao;

//MessageDao接口类的实现
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
				messageList.add(mb);// 将留言列表的bean添加到集合类中
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

	// 插入留言
	public int add(MessageBean messagebean) {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "insert into message(Name,MessageThem,MessageTitle,MessageContent,udate) "
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
					+ messagebean.getDate1() + "'" + ")";
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

	// 删除留言
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

	// 修改留言
	public int updata(MessageBean messagebean, int id) {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "update message set MessageThem='"
					+ messagebean.getMessageThem() + "',MessageContent='"
					+ messagebean.getMessageContent() + "',MessageReply='"
					+ messagebean.getMessageReply() + "',udate='"
					+ messagebean.getDate1() + "',replydate='"
					+ messagebean.getReplyDate() + "' where id='" + id + "'";
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

	// 回复留言
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
				messageList.add(mb);// 将留言列表的bean添加到集合类中
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
				messageList.add(mb); // 将查询到的结果放入集合中
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

	// 分页
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

	// 分页查找
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
				messageList.add(mb);// 将留言列表的bean添加到集合类中
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

	// 登录验证
	public LoginBean checklogin(String adminName, String password) {

		LoginBean login = new LoginBean();
		try {
			con = DBconn.getConn();
			pstmt = con
					.prepareStatement("select* from admin where adminName=? "
							+ " and adminPassword=?");
			pstmt.setString(1, adminName); // 设置SQL语句参数
			pstmt.setString(2, password); // 设置SQL语句参数
			ResultSet rs = pstmt.executeQuery(); // ִ执行查询，返回结果
			if (rs.next()) { // ͨ通过JavaBean保存数据ֵ

				login.setAdminName(rs.getString(1));
				login.setPassword(rs.getString(2));
				// 返回JavaBean对象
				return login;
			}
			// 验证失败返回null
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

}