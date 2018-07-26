package com.edoctor.api;

import com.edoctor.bean.RestMessage;
import com.edoctor.bean.User;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.web.bind.annotation.*;

@Api(value = "消息队列统计及操作API")
@RestController
@RequestMapping("/api/v1/mq/operation")
public class MQApi {

    @Autowired
    JmsOperations jmsOperations;

    private static final Logger LOG = LoggerFactory.getLogger(MQApi.class);

    @ApiOperation(value = "向队列中插入一条数据", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mq server down", response = RestMessage.class)
    })
    @RequestMapping(value = "insertOneStringToMQ", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<User> insertOneObjectToMQ(
            @ApiParam(name = "str", required = true, value = "插入MQ的字符串") @RequestParam(value = "str") String str) {
        RestMessage<User> restMessage = new RestMessage<>();
        User user = new User();
        user.setId("10086");
        user.setSex("male");
        user.setUsername("帅哥");
        jmsOperations.convertAndSend(user);
        restMessage.setCode(200).setMsg("success: insert successfully").setData(user);
        return restMessage;
    }

    @ApiOperation(value = "从队列中读取一条数据", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mq server down", response = RestMessage.class)
    })
    @RequestMapping(value = "getOneObjectFromMQ", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<User> getOneObjectFromMQ() {
        RestMessage<User> restMessage = new RestMessage<>();
        User value = (User)jmsOperations.receiveAndConvert();
        restMessage.setCode(200).setMsg("success: insert successfully").setData(value);
        return restMessage;
    }
}
