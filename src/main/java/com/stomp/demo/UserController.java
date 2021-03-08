package com.stomp.demo;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(path = "user")
@RestController
public class UserController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public UserController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping(path = "{msg}")
    public void user(@PathVariable String msg) {
        System.out.println(msg);
        simpMessagingTemplate.convertAndSend("/topic/user-name", msg);
    }

    @MessageMapping("username")
    @SendTo("/topic/user-name")
    public String userSend(String msg) {
        System.out.println(msg);
        return "{cc:\""+msg+"\"}";
    }
}
