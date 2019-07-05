package bean;

public class ReplyBean {
	private int ID, MsgId;
	private String Name, ReplyContent, ReplyDate1;

	public String getReplyDate1() {
		return ReplyDate1;
	}

	public void setReplyDate1(String replyDate1) {
		this.ReplyDate1 = replyDate1;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getMsgId() {
		return MsgId;
	}

	public void setMsgId(int msgId) {
		MsgId = msgId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getReplyContent() {
		return ReplyContent;
	}

	public void setReplyContent(String replyContent) {
		ReplyContent = replyContent;
	}

}
