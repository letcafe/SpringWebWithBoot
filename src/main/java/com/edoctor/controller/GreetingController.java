package com.edoctor.controller;

import com.edoctor.bean.Device;
import com.edoctor.bean.RestMessage;
import com.edoctor.service.DeviceRepository;
import com.edoctor.service.EmailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.List;

@Api(value = "消息队列统计及操作API")
@RestController
@RequestMapping("/")
public class GreetingController {

    private DeviceRepository deviceRepository;

    private EmailService emailService;

    @Autowired
    GreetingController(DeviceRepository deviceRepository, EmailService emailService) {
        this.deviceRepository = deviceRepository;
        this.emailService = emailService;
    }


}
