package com.edoctor.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/macropolo").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 设置使用简单的STOMP功能,通过基于内存模拟STOMP的多项功能
//        registry.enableSimpleBroker("/queue", "/topic");
        // 设置使用消息代理,例如RabbitMQ或者RocketMQ进行处理,如果消息代理有账号密码将设置其地址等信息
        registry.enableStompBrokerRelay("/queue", "/topic")
                .setRelayHost("127.0.0.1")
                .setRelayPort(61613)
                .setClientLogin("username")
                .setClientPasscode("password");

        // 设置前缀为"/app","/foo"转发至带有@MessageMapping的控制器上处理
        registry.setApplicationDestinationPrefixes("/app", "/foo");
    }
}
