package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBconn;

public class MessageBean {
	private int ID;
	private String Name, MessageThem, MessgaeTitle, MessageContent, date1, account;
	private String replyNum;

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMessageThem() {
		return MessageThem;
	}

	public void setMessageThem(String messageThem) {
		MessageThem = messageThem;
	}

	public String getMessgaeTitle() {
		return MessgaeTitle;
	}

	public void setMessgaeTitle(String messgaeTitle) {
		MessgaeTitle = messgaeTitle;
	}

	public String getMessageContent() {
		return MessageContent;
	}

	public void setMessageContent(String messageContent) {
		MessageContent = messageContent;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(String replyNum) {
		this.replyNum = replyNum;
	}
	

}
