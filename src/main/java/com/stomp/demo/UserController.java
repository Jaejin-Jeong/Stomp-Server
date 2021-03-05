package com.stomp.demo;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public UserController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping(path = "user/{msg}")
    public void user(@PathVariable String msg) {
        System.out.println(msg);
        simpMessagingTemplate.convertAndSend("/topic/user-name", msg);
    }

//    @GetMapping(path = "user/{msg}")
//    @SendTo("/topic/user-name")
//    public String userSend(@PathVariable String msg) {
//        System.out.println(msg);
//        return "{cc:\""+msg+"\"}";
//    }
}
