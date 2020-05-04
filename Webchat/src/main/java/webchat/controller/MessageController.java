package webchat.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import webchat.model.Message;



@Controller
public class MessageController 
{
	/**
	 * ����urlΪapp/chat/message�����󣬽������������Ϣ��ת��
	 * @param request
	 */
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@MessageMapping("/chat/message")
	 public void receiveMessage(Message m)
	{
		Date Time = new Date();
		m.setSendTime(Time);
		messagingTemplate.convertAndSend("topic/chat/message",m);
	}
	
}
