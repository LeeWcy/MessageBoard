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
	// ���ݿ����Ӷ���
	PreparedStatement pstmt;

	public OrderByTimeServerlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������
		request.setCharacterEncoding("utf-8");
		// ������Ӧ����
		response.setContentType("utf-8");
		Business business = new Business();
		 ArrayList<MessBor> al = business.OrderByTime();
		 System.out.println("��ʱ���ѯ�����ģ�"+al);
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
