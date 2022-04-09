package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello") //This ensures that if message is sent to the /hello destination, the greeting() method is called
    @SendTo("/topic/greetings") //The payload of the message is bound to a HelloMessage, and is passed into greeting(0
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello," + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
