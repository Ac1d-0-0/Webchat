package webchat.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer 
{

	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) 
	{
		stompEndpointRegistry.addEndpoint("/websocket").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
	}
    /*
     * ������Ϣ������/appΪͷ��url�����Ⱦ���MessageMapping 
      topicֱ�ӽ�����Ϣ����ת����ǰ�˼����˿ڣ�
     */
	public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }


}
