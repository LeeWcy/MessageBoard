package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Business;
import DAO.DBConn;
import DAO.LoginDao;
import DAO.MessBor;

@WebServlet("/OrderByTimeServerlet")
public class OrderByTimeServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = DBConn.getConn();
	// 数据库连接对象
	PreparedStatement pstmt;

	public OrderByTimeServerlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编码
		request.setCharacterEncoding("utf-8");
		// 设置响应编码
		response.setContentType("utf-8");
		Business business = new Business();
		 ArrayList<MessBor> al = business.OrderByTime();
		 System.out.println("按时间查询出来的："+al);
		 for(int i=0;i<al.size();i++) {
				MessBor mb = al.get(i);
				System.out.println("第"+i+"条查询结果：");
				System.out.println("  时间："+mb.getTime().toString());
				System.out.println("  标题："+mb.getTitle());
				System.out.println("  内容："+mb.getMessage());
				System.out.println("  作者："+new LoginDao().getName(mb.getId()));
			 }
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
