package com.edoctor.controller;

import com.edoctor.bean.Device;
import com.edoctor.bean.RestMessage;
import com.edoctor.service.DeviceRepository;
import com.edoctor.util.EmailUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    private EmailUtil emailUtil;

    @Autowired
    GreetingController(DeviceRepository deviceRepository, EmailUtil emailUtil) {
        this.deviceRepository = deviceRepository;
        this.emailUtil = emailUtil;
    }


    @RequestMapping(value = "greeting", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<List<Device>> greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) throws MessagingException {
        RestMessage<List<Device>> restMessage = new RestMessage<>();
        emailUtil.sendSimpleTextEmail("gdycn@qq.com","letcafe@outlook.com", "helloWorld", LocalDateTime.now().toString());
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }


}
