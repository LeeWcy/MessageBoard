package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MessageBean;
import dao.MessageDao;

public class MessageList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDao note = new MessageDao();

		try {
			String id=request.getParameter("search");
			System.out.println(id);
			List<MessageBean> list = note.FindByString(id);
			System.out.println(list);
			request.setAttribute("message", list);
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
