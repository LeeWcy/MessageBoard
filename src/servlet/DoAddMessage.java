package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.LoginBean;
import bean.MessageBean;
import dao.MessageDao;

public class DoAddMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		LoginBean l=(LoginBean) request.getSession().getAttribute("login");
		String name = l.getAdminName();
		String account = l.getAccount();
		String messageThem = request.getParameter("them");
		String messageTitle = request.getParameter("title");
		String messageContent = request.getParameter("content");

		Date date = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String Date = sdformat.format(date);
		MessageBean messagebean = new MessageBean();
		messagebean.setName(name);
		messagebean.setMessageThem(messageThem);
		messagebean.setMessgaeTitle(messageTitle);
		messagebean.setMessageContent(messageContent);
		messagebean.setDate1(Date);
		messagebean.setAccount(account);
		MessageDao messagedao = new MessageDao();
		int n = messagedao.add(messagebean);
		if (n > 0) {
			String pageNo = "1";
			String _pageNo = request.getParameter("pageNo");
			if (_pageNo != null) {
				pageNo = _pageNo;
			}
			int pageNo1 = Integer.parseInt(pageNo);
			int count = messagedao.getCount();
			int num = 5;
			int page = (int) Math.ceil(count * 1.0 / num);
			request.setAttribute("page", page);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("message",
					messagedao.getMessagesByPage(pageNo1, num));
			request.getRequestDispatcher("messageList.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("error.jsp");
		}

	}

}
