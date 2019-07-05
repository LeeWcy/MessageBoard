package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import bean.MessageBean;
import bean.ReplyBean;
import dao.MessageDao;
import dao.ReplyDao;

public class DetailsMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		LoginBean login = (LoginBean) request.getSession().getAttribute("login");
		MessageDao note = new MessageDao();
		ReplyDao note1 = new ReplyDao();
		try {
			int DM = new Integer(request.getParameter("id"));
			List<MessageBean> list = note.detailMessages(DM);
			List<ReplyBean> list1 = note1.getMessageReply(DM);
			request.setAttribute("message", list);
			request.setAttribute("reply", list1);
			if (login != null) {
				request.getRequestDispatcher("details.jsp").forward(request,
						response);
			} else
				request.getRequestDispatcher("detailsMessage.jsp").forward(request,
						response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
