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
import dao.MessageDao;

public class MessageView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MessageDao note = new MessageDao();
		LoginBean login = (LoginBean) session.getAttribute("login");
		String pageNo = "1";
		String _pageNo = request.getParameter("pageNo");
		if (_pageNo != null) {
			pageNo = _pageNo;
		}
		int pageNo1 = Integer.parseInt(pageNo);
		int count = note.getCount();
		int num = 5;
		int page = (int) Math.ceil(count * 1.0 / num);
		request.setAttribute("page", page);
		request.setAttribute("pageNo", pageNo);
		try {
			List<MessageBean> list = note.getMessagesByPage(pageNo1, num);
			request.setAttribute("message", list);
			if (login != null && login.getAuth()==0) {
				request.getRequestDispatcher("messageView.jsp").forward(
						request, response);
			} else
				request.getRequestDispatcher("messageList.jsp").forward(
						request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
