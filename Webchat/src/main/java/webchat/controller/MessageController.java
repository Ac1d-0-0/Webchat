package webchat.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import webchat.model.Message;
import webchat.model.User;
import webchat.service.UserService;



@Controller
public class MessageController 
{
	/**
	 * 接收url为app/chat/message的请求，解析请求，完成消息的转发
	 * @param request
	 */
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Resource
	private UserService uservice;
	@MessageMapping("/chat/message")
	 public void receiveMessage(Message m)
	{
		Date Time = new Date();
		m.setSendTime(Time);
		User from = uservice.GetUserbyid(m.getMessagefrom());
		User to = uservice.GetUserbyid(m.getMessageto());
		int i=0 ;
		if(from!=null) {
			i = uservice.isfriend(from.getUserId(), to.getUserId());
		}	
		if(i!=0||m.getMessageto()==99999)
		{
			m.setFromName(from.getUserName());
			m.setToName(to.getUserName());
			messagingTemplate.convertAndSend("/topic/chat/message",m);
		}
	}
	
}
