package com.example.websocketfirst.controllers;

import com.example.websocketfirst.domain.Greeting;
import com.example.websocketfirst.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("User write,    " +
                HtmlUtils.htmlEscape(message.getText()) + "!");
    }
}
