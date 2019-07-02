package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Login;
import DAO.LoginDao;
import DAO.MessBor;

@WebServlet("/LeaveMessage")
public class LeaveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LeaveMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������				
		request.setCharacterEncoding("utf-8");				
		// ������Ӧ����				
		response.setContentType("utf-8");				
		// ��ȡtitle����				
		String title=request.getParameter("title");				
		// ��ȡmessage����				
		String message=request.getParameter("message");				
		// ��session��ȡ����ǰ�û�����				
		Login leaveMessageBoard=(Login) request.getSession().getAttribute("login");				
		// �������Ա��ӦJavaBean���󣬰����ݷ�װ��ȥ				
		MessBor mb=new MessBor();				
		mb.setId(leaveMessageBoard.getId());				
		// ����Ϊ��ȡ�ĵ�ǰʱ��				
		mb.setName(leaveMessageBoard.getName());				
		mb.setTime(new Date(System.currentTimeMillis()));				
		mb.setTitle(title);				
		mb.setMessage(message);				
		// ��DB���еķ����ж��Ƿ����ɹ�				
		if(new LoginDao().addInfo(mb)){					
			response.sendRedirect("success.jsp") ;				
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
