package com.edoctor.api;

import com.edoctor.bean.RestMessage;
import com.edoctor.bean.StompBean;
import com.edoctor.service.StompBeanService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Redis操作API")
@RestController
@RequestMapping("/api/v1/redis")
public class StompApi {

    private StompBeanService stompBeanService;

    @Autowired
    public StompApi(StompBeanService stompBeanService) {
        this.stompBeanService = stompBeanService;
    }

    @ApiOperation(value = "向队里中发送一条消息", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/sendStompToMQ", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<String> redisObjectSetter(
            @ApiParam(name = "message", required = true, value = "用于给StompBean初始化的字符串值") @RequestParam(name = "message") String message){
        RestMessage<String> restMessage = new RestMessage<>();
        StompBean stompBean = new StompBean(message);
        stompBeanService.broadcastStompBean(stompBean);
        restMessage.setCode(200).setMsg("success");
        return restMessage;
    }
}
