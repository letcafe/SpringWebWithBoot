package com.edoctor.api;

import com.edoctor.bean.RestMessage;
import com.edoctor.service.RedisService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Redis操作API")
@RestController
@RequestMapping("/api/v1/redis")
public class RedisApi {

    @Autowired
    RedisService redisService;

    @ApiOperation(value = "设置String -> Object值", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/redisObjectSetter", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<String> redisObjectSetter(
            @ApiParam(name = "key", required = true, value = "key值") @RequestParam(name = "key") String key){
        RestMessage<String> restMessage = new RestMessage<>();
        redisService.setKeyValue(key, "123");
        restMessage.setCode(200).setMsg("success").setData(redisService.getKeyValue(key));
        return restMessage;
    }

    @ApiOperation(value = "获取String -> Object值", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/redisObjectGetter", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<String> redisObjectGetter(
            @ApiParam(name = "key", required = true, value = "key值") @RequestParam(name = "key") String key){
        RestMessage<String> restMessage = new RestMessage<>();
        restMessage.setCode(200).setMsg("success").setData(redisService.getKeyValue(key));
        return restMessage;
    }
}
