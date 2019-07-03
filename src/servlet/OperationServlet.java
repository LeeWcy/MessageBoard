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

import bean.MessageBean;
import dao.MessageDao;

public class OperationServlet extends HttpServlet {
	public void right(){
		 
        String msg="删除留言成功！！！";
        int type=JOptionPane.YES_NO_CANCEL_OPTION;
        String title="信息提示";
        JOptionPane.showMessageDialog(null, msg, title, type);
     }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		MessageBean messagebean = new MessageBean();
		int id = new Integer(request.getParameter("id"));
		String flag = request.getParameter("flag");
		MessageDao dao = new MessageDao();
		String pageNo = "1";
		String _pageNo = request.getParameter("pageNo");
		System.out.println(_pageNo);
		if (_pageNo != null) {
			pageNo = _pageNo;
		}
		int pageNo1 = Integer.parseInt(pageNo);
		int count = dao.getCount();// 获取总条数;
		int num = 5;// 每页显示三条
		int page = (int) Math.ceil(count * 1.0 / num);
		request.setAttribute("page", page);// 将总条数传到jsp页面
		request.setAttribute("pageNo", pageNo);
		// 删除
		if (flag.equals("Delete")) {
			int n = dao.delete(id);
			if (n > 0) {
				right();
				request.setAttribute("message",
						dao.getMessagesByPage(pageNo1, num));
				request.getRequestDispatcher("messageView.jsp").forward(
						request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		}
		// 修改留言的业务处理
		else if (flag.equals("Updata")) {
			String messageThem = request.getParameter("them");
			String messageTitle = request.getParameter("title");
			String messageContent = request.getParameter("content");
			String messageReplyContent = request.getParameter("replyContent");
			Date date = new Date();
			SimpleDateFormat sdformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String Date = sdformat.format(date);

			messagebean.setMessageReply(messageReplyContent);
			messagebean.setMessageThem(messageThem);
			messagebean.setMessgaeTitle(messageTitle);
			messagebean.setMessageContent(messageContent);
			messagebean.setDate1(Date);
			if (messageReplyContent != null) {
				messagebean.setReplyDate(Date);
			}
			int n = dao.updata(messagebean, id);
			if (n > 0) {
				request.setAttribute("message",
						dao.getMessagesByPage(pageNo1, num));
				request.getRequestDispatcher("messageView.jsp").forward(
						request, response);
			}
		}
		// 回复留言
		else if (flag.equals("reply")) {
			String messageReplyContent = request.getParameter("replyContent");
			Date date = new Date();
			SimpleDateFormat sdformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String replyDate = sdformat.format(date);
			System.out.println(id);
			messagebean.setMessageReply(messageReplyContent);
			messagebean.setReplyDate(replyDate);
			int n = dao.reply(messagebean, id);
			if (n > 0) {
				List<MessageBean> list = dao.detailMessages(id);
				request.setAttribute("message", list);
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
			request.setAttribute("message", list);
			request.getRequestDispatcher("details.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
