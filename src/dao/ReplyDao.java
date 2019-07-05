package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MessageBean;
import bean.ReplyBean;

public class ReplyDao {
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs;
	private String sql;
	
	

	public List<ReplyBean> getMyReplys(String name) {
		List<ReplyBean> replyList = new ArrayList<ReplyBean>();
		try {
			con = DBconn.getConn();
			sql = "select * from reply where account='" + name + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReplyBean mb = new ReplyBean();
				mb.setID(rs.getInt("id"));
				mb.setName(rs.getString("Name"));
				mb.setReplyContent(rs.getString("ReplyContent"));
				mb.setReplyDate1(rs.getString("replyDate1"));
				replyList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return replyList;
	}

	public int reply(ReplyBean replybean, int id) {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "insert into reply(Name,ReplyContent,Replydate,MsgId) "
					+ "value("
					+ "'"
					+ replybean.getName()
					+ "'"
					+ ","
					+ "'"
					+ replybean.getReplyContent()
					+ "'"
					+ ","
					+ "'"
					+ replybean.getReplyDate1() 
					+ "'"
					+ ","
					+ "'"
					+ id + "'" + ")";
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
	
	
	public List<ReplyBean> getMessageReply(int id) {
		List<ReplyBean> replyList = new ArrayList<ReplyBean>();
		try {
			con = DBconn.getConn();
			sql = "select * from reply where msgid='" + id + "' ORDER BY id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReplyBean mb = new ReplyBean();
				mb.setID(rs.getInt("id"));
				mb.setName(rs.getString("Name"));
				mb.setReplyContent(rs.getString("ReplyContent"));
				mb.setReplyDate1(rs.getString("Replydate"));
				replyList.add(mb);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DBconn.closeResultSet(rs);
			DBconn.closeStatement(pstmt);
			DBconn.CloseConn();
		}
		return replyList;
	}

	public int delete(int id) {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "delete from reply where id ='" + id + "'";
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


//	public int updata(ReplyBean replybean, int id) {
//		int re = 0;
//		try {
//			con = DBconn.getConn();
//			sql = "update reply set ReplyContent='"
//					+ replybean.getReplyContent() + "',Replydate='"
//					+ replybean.getReplyDate1() + "' where id='" + id + "'";
//			pstmt = con.prepareStatement(sql);
//			re = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBconn.closeResultSet(rs);
//			DBconn.closeStatement(pstmt);
//			DBconn.CloseConn();
//		}
//		return re;
//	}

	
	public int getCount() {
		int re = 0;
		try {
			con = DBconn.getConn();
			sql = "select count(id) from reply";
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

	
//鎰熻娌″繀瑕�,娌℃敼瀹�	
//	public List<ReplyBean> getReplyByPage(int pageNo, int num) {
//		List<ReplyBean> replyList = new ArrayList<ReplyBean>();
//		try {
//			int num1 = (pageNo - 1) * num;
//			con = DBconn.getConn();
//			pstmt = con.prepareStatement("SELECT * FROM reply limit " + num1
//					+ "," + num);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				MessageBean mb = new MessageBean();
//				mb.setID(rs.getInt("id"));
//				mb.setName(rs.getString("Name"));
//				mb.setMessageThem(rs.getString("MessageThem"));
//				mb.setMessgaeTitle(rs.getString("MessageTitle"));
//				mb.setMessageContent(rs.getString("MessageContent"));
//				mb.setDate1(rs.getString("udate"));
//				messageList.add(mb);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// DBconn.closeResultSet(rs);
//			// DBconn.closeStatement(pstmt);
//			// DBconn.getConn();
//		}
//		return messageList;
//	}

	

}
