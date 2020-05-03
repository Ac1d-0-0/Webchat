package webchat.model;

import java.util.Date;

public class Message 
{
	private String MessageId;
	private String Messageto;
	private String Messagefrom;
	private String MessageContent;
	private Date SendTime;
	
	public Message(String messageId, String messageto, String messagefrom, String messageContent, Date sendTime) 
	{
		this.MessageId = messageId;
		this.Messageto = messageto;
		this.Messagefrom = messagefrom;
		this.MessageContent = messageContent;
		this.SendTime = sendTime;
	}
	public String getMessageId() {
		return MessageId;
	}
	public void setMessageId(String messageId) {
		MessageId = messageId;
	}
	public String getMessageto() {
		return Messageto;
	}
	public void setMessageto(String messageto) {
		Messageto = messageto;
	}
	public String getMessagefrom() {
		return Messagefrom;
	}
	public void setMessagefrom(String messagefrom) {
		Messagefrom = messagefrom;
	}
	public String getMessageContent() {
		return MessageContent;
	}
	public void setMessageContent(String messageContent) {
		MessageContent = messageContent;
	}
	public Date getSendTime() {
		return SendTime;
	}
	public void setSendTime(Date sendTime) {
		SendTime = sendTime;
	}

	
	
}
