package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Login;
import DAO.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������
		request.setCharacterEncoding("utf-8");
		// ������Ӧ����
		response.setContentType("utf-8");
		LoginDao loginDao = new LoginDao();
		HttpSession session = request.getSession();
		// �Ȼ��user��������ǵ�һ�η��ʸ�Servlet���û�����϶�Ϊ�գ�
		//������ǵڶ��������ǵ����Σ��Ͳ�Ӧ�����жϸ��û�����Ϣ
		Login l = (Login) session.getAttribute("login");
		if (l == null)
			l = loginDao.checkLogin(request.getParameter("name"), request.getParameter("password"));
		if (l != null) {
			// �����½�ɹ�
			session.setAttribute("login", l);
			// ����ȡ�Ķ��󱣴���session��
			ArrayList al = loginDao.findMbInfo();
			// ��ȡ���԰�����ݣ�����һ������
			session.setAttribute("al", al);
			// �����鱣������
			response.sendRedirect("main.jsp");
			// ��֤�ɹ���ת�� main.jsp
			return;
		} else {
			// ��֤ʧ����ת�� error.jsp
			response.sendRedirect("error.jsp");
			
		}
		if(session!=null) {
			response.sendRedirect("login.jsp");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
