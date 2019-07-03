package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name = request.getParameter("name");
		String messageThem = request.getParameter("them");
		String messageTitle = request.getParameter("title");
		String messageContent = request.getParameter("content");

		Date date = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String Date = sdformat.format(date);
		String replyDate = "";
		MessageBean messagebean = new MessageBean();
		messagebean.setName(name);
		messagebean.setMessageThem(messageThem);
		messagebean.setMessgaeTitle(messageTitle);
		messagebean.setMessageContent(messageContent);
		messagebean.setDate1(Date);
		MessageDao messagedao = new MessageDao();
		int n = messagedao.add(messagebean);
		if (n > 0) {
			String pageNo = "1";
			String _pageNo = request.getParameter("pageNo");
			if (_pageNo != null) {
				pageNo = _pageNo;
			}
			int pageNo1 = Integer.parseInt(pageNo);
			int count = messagedao.getCount();// 获取总条数;
			int num = 5;// 每页显示三条
			int page = (int) Math.ceil(count * 1.0 / num);
			request.setAttribute("page", page);// 将总条数传到jsp页面
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
