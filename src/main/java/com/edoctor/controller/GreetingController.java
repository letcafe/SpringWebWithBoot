package com.edoctor.controller;

import com.edoctor.bean.Device;
import com.edoctor.bean.RestMessage;
import com.edoctor.service.DeviceRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "消息队列统计及操作API")
@RestController
@RequestMapping("/")
public class GreetingController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(value = "greeting", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<List<Device>> greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        RestMessage<List<Device>> restMessage = new RestMessage<>();
        restMessage.setCode(200).setMsg("success").setData(deviceRepository.getDevicesByNameEquals(name));
        return restMessage;
    }


}
