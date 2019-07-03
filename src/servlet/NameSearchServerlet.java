package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import DAO.DBConn;
import DAO.Login;
import DAO.LoginDao;
import DAO.MessBor;

@WebServlet("/NameSearchServerlet")
public class NameSearchServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = DBConn.getConn();
	// ���ݿ����Ӷ���
	PreparedStatement pstmt;

	public NameSearchServerlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������
		request.setCharacterEncoding("utf-8");
		// ������Ӧ����
		response.setContentType("utf-8");
		LoginDao loginDao = new LoginDao();
		String search=request.getParameter("search_by_name");
		 System.out.println("��������������"+search);
		 ArrayList<MessBor> al = loginDao.findMbInfo(search);
		 for(int i=0;i<al.size();i++) {
			MessBor mb = al.get(i);
			System.out.println("��"+i+"����ѯ�����");
			System.out.println("  ʱ�䣺"+mb.getTime().toString());
			System.out.println("  ���⣺"+mb.getTitle());
			System.out.println("  ���ݣ�"+mb.getMessage());
			System.out.println("  ���ߣ�"+new LoginDao().getName(mb.getId()));
		 }
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
