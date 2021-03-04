package com.stomp.demo;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(path = "user")
    @SendTo("/topic/a")
    public String user() {
        System.out.println("user");
        return "ddddddddddddddddd";
    }
}
