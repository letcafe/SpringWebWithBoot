package com.edoctor.api;

import com.edoctor.bean.Device;
import com.edoctor.bean.RestMessage;
import com.edoctor.service.DeviceRepository;
import com.edoctor.util.EmailUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Api(value = "消息队列统计及操作API")
@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private DeviceRepository deviceRepository;

    private EmailUtil emailUtil;

    @Autowired
    EmailController(DeviceRepository deviceRepository, EmailUtil emailUtil) {
        this.deviceRepository = deviceRepository;
        this.emailUtil = emailUtil;
    }

    @ApiOperation(value = "增加一条设备日志记录，返回Mongo中已存入的日志", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<List<Device>> greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) throws MessagingException {
        RestMessage<List<Device>> restMessage = new RestMessage<>();
//        emailUtil.sendSimpleTextEmail("gdycn@qq.com","letcafe@outlook.com", "helloWorld", LocalDateTime.now().toString());
        List<String> fileList = new LinkedList<>();
        fileList.add("coupon.jpg");
        fileList.add("ice.png");
        fileList.add("冰PC.png");
        fileList.add("项目迁移后台架构调整.ppt");
        fileList.add("天津电信资.xlsx");
        emailUtil.sendEmailWithFile("gdycn@qq.com", "letcafe@outlook.com", "helloWorld", LocalDateTime.now().toString(), fileList);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }


}
