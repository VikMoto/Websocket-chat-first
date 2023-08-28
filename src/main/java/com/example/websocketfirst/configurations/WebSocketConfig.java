package com.example.websocketfirst.configurations;

import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//    @Value("${spring.rabbitmq.host}")
//    @NonFinal
//    String host;
//
//    @Value("${spring.rabbitmq.username}")
//    @NonFinal
//    String username;
//
//    @Value("${spring.rabbitmq.password}")
//    @NonFinal
//    String password;
    private static final String TOPIC_PREFIX = "/topic" ;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker(TOPIC_PREFIX);
        config.setApplicationDestinationPrefixes("/app");
//        config.enableStompBrokerRelay(TOPIC_PREFIX)
//                .setRelayHost(host)
//                .setClientLogin(username)
//                .setClientPasscode(password)
//                .setSystemLogin(username)
//                .setSystemPasscode(password);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws");
    }

}