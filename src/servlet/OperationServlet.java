package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.LoginBean;
import bean.MessageBean;
import bean.ReplyBean;
import dao.MessageDao;
import dao.ReplyDao;

public class OperationServlet extends HttpServlet {
	public void right(){
		 
        String msg="操作成功";
        int type=JOptionPane.YES_NO_CANCEL_OPTION;
        String title="操作";
        JOptionPane.showMessageDialog(null, msg, title, type);
     }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		MessageBean messagebean = new MessageBean();
		ReplyBean replybean = new ReplyBean();
		int id = new Integer(request.getParameter("id"));
		String flag = request.getParameter("flag");
		LoginBean login = (LoginBean) request.getSession().getAttribute("login");
		MessageDao dao = new MessageDao();
		ReplyDao dao1 = new ReplyDao();
		String pageNo = "1";
		String _pageNo = request.getParameter("pageNo");
		System.out.println(_pageNo);
		if (_pageNo != null) {
			pageNo = _pageNo;
		}
		int pageNo1 = Integer.parseInt(pageNo);
		int count = dao.getCount();
		int num = 5;
		int page = (int) Math.ceil(count * 1.0 / num);
		request.setAttribute("page", page);
		request.setAttribute("pageNo", pageNo);
		if (flag.equals("Delete")) {
		int n = dao.delete(id);
		response.sendRedirect("MessageView");
//			if (n > 0) {
//				right();
//				request.setAttribute("message",
//						dao.getMessagesByPage(pageNo1, num));
//				response.sendRedirect("MessageView");
//				request.getRequestDispatcher("messageList.jsp").forward(
//					request, response);
//			} else {
//				response.sendRedirect("error.jsp");
//			}
		}
		else if (flag.equals("Updata")) {
			String messageThem = request.getParameter("them");
			String messageTitle = request.getParameter("title");
			String messageContent = request.getParameter("content");
			Date date = new Date();
			SimpleDateFormat sdformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String Date = sdformat.format(date);

			messagebean.setMessageThem(messageThem);
			messagebean.setMessgaeTitle(messageTitle);
			messagebean.setMessageContent(messageContent);
			messagebean.setDate1(Date);
			int n = dao.updata(messagebean, id);
			if (n > 0) {
				request.setAttribute("message",
						dao.getMessagesByPage(pageNo1, num));
				request.getRequestDispatcher("messageView.jsp").forward(
						request, response);
			}
		}
		else if (flag.equals("reply")) {
			String replyContent = request.getParameter("replyContent");
			String name = login.getAdminName();
			Date date = new Date();
			SimpleDateFormat sdformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String replyDate = sdformat.format(date);
			System.out.println(id);
			replybean.setReplyContent(replyContent);
			replybean.setReplyDate1(replyDate);
			replybean.setName(name);
			int n = dao1.reply(replybean, id);
			if (n > 0) {
				List<MessageBean> list = dao.detailMessages(id);
				List<ReplyBean> list1 = dao1.getMessageReply(id);
				request.setAttribute("message", list);
				request.setAttribute("reply", list1);
				request.getRequestDispatcher("details.jsp").forward(request,
						response);
			}

		} else if (flag.equals("HF")) {
			List<MessageBean> list = dao.detailMessages(id);
			request.setAttribute("message", list);
			request.getRequestDispatcher("reply.jsp")
					.forward(request, response);
		} else if (flag.equals("XG")) {
			List<MessageBean> list = dao.detailMessages(id);
			request.setAttribute("message", list);
			request.getRequestDispatcher("Updata.jsp").forward(request,
					response);
		} else if (flag.equals("XQ")) {
			List<MessageBean> list = dao.detailMessages(id);
			List<ReplyBean> list1 = dao1.getMessageReply(id);
			request.setAttribute("message", list);
			request.setAttribute("reply", list1);
			request.getRequestDispatcher("details.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
