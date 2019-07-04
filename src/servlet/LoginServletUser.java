package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginBean;
import bean.MessageBean;
import dao.MessageDao;

public class LoginServletUser extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("gb2312");
		response.setContentType("gb2312");
		String adminName = request.getParameter("account");
		String password = request.getParameter("password");
		String authCode = request.getParameter("authcode");
		String piccode = request.getSession().getAttribute("piccode")
				.toString();
		LoginBean login = new LoginBean();
		MessageDao logindao = new MessageDao();
		login = logindao.checkuserlogin(adminName, password);
		
		if (login == null ) {
			System.out.println("�˻��������");
		}
		if (login != null && authCode.equals(piccode)) {
			List<MessageBean> list = new ArrayList<MessageBean>();
			list = logindao.getMessages();
			request.setAttribute("list", list);
			session.setAttribute("login", login);
			response.sendRedirect("MessageView");
		}else {
			System.out.println("��֤���������");
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
