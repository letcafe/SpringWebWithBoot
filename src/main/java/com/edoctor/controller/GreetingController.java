package com.edoctor.controller;

import com.edoctor.service.EmailService;
import com.edoctor.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "消息队列统计及操作API")
@RestController
@RequestMapping("/")
public class GreetingController {

    private UserService userService;

    private EmailService emailService;

    @Autowired
    GreetingController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }


}
