package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginBean;
import bean.MessageBean;
import bean.ReplyBean;
import dao.MessageDao;
import dao.ReplyDao;


public class PersonalCenter extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDao note = new MessageDao();
		ReplyDao note1 = new ReplyDao();
		try {
			HttpSession session = request.getSession();
		    LoginBean login = (LoginBean) session.getAttribute("login");
		    String name = login.getAdminName();
			List<MessageBean> list = note.getMyMessages(name);
			request.setAttribute("message", list);
			if (login != null) {
				List<ReplyBean> list1 = note1.getMyReplys(name);
				request.setAttribute("reply", list1);
				request.getRequestDispatcher("personalCenter.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
