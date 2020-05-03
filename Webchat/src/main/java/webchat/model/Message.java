package webchat.model;

import java.util.Date;

public class Message 
{
	private int Messageto;
	private int Messagefrom;
	private String MessageContent;
	private Date SendTime;
	
	public Message( int messageto, int messagefrom, String messageContent, Date sendTime) 
	{
		this.Messageto = messageto;
		this.Messagefrom = messagefrom;
		this.MessageContent = messageContent;
		this.SendTime = sendTime;
	}

	public int getMessageto() {
		return Messageto;
	}
	public void setMessageto(int messageto) {
		Messageto = messageto;
	}
	public int getMessagefrom() {
		return Messagefrom;
	}
	public void setMessagefrom(int messagefrom) {
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
