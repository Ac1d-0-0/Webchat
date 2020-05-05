package webchat.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message 
{
	private int Messageto;
	private int Messagefrom;
	private String MessageContent;
	private Date SendTime;
	private String fromName;
	private String toName;
	@JsonCreator
	public Message(@JsonProperty("Messageto") int messageto, 
				   @JsonProperty("MessageContent")String messageContent,
				   @JsonProperty("Messagefrom") int messagefrom) 
	{
		Messageto = messageto;
		MessageContent = messageContent;
		Messagefrom = messagefrom;
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
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	
	
	
}
