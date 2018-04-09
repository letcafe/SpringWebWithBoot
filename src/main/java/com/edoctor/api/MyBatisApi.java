package com.edoctor.api;

import com.edoctor.bean.RestMessage;
import com.edoctor.bean.User;
import com.edoctor.dao.UserDao;
import com.edoctor.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "MyBatis操作API")
@RestController
@RequestMapping("/api/v1/mybatis")
public class MyBatisApi {

    @Autowired
    UserService userService;

    @ApiOperation(value = "获取对象List", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<List<User>> getUserList(){
        RestMessage<List<User>> restMessage = new RestMessage<>();
        List<User> users = userService.getUserList();
        restMessage.setCode(200).setMsg("success").setData(users);
        return restMessage;
    }

    @ApiOperation(value = "根据UserId获取值", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<User> getUserById(
            @ApiParam(name = "userId", required = true, value = "用户Id值") @RequestParam(name = "userId") Integer userId){
        RestMessage<User> restMessage = new RestMessage<>();
        User user = userService.getUserById(userId);
        restMessage.setCode(200).setMsg("success").setData(user);
        return restMessage;
    }

    @ApiOperation(value = "获取统计的行数", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<Long> count(){
        RestMessage<Long> restMessage = new RestMessage<>();
        Long lineNum = userService.count();
        restMessage.setCode(200).setMsg("success").setData(lineNum);
        return restMessage;
    }

    @ApiOperation(value = "更新用户个人信息（更改性别）", httpMethod = "PUT", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/updateUserById", method = RequestMethod.PUT, produces = "application/json")
    public RestMessage<User> updateUserById(
            @ApiParam(name = "userId", required = true, value = "用户Id值") @RequestParam(name = "userId") Integer userId,
            @ApiParam(name = "sex", required = true, value = "用户性别") @RequestParam(name = "sex") String sex){
        RestMessage<User> restMessage = new RestMessage<>();
        userService.updateUserSexById(userId, sex);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }

    @ApiOperation(value = "删除一个用户", httpMethod = "DELETE", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.DELETE, produces = "application/json")
    public RestMessage<User> deleteUserById(
            @ApiParam(name = "userId", required = true, value = "用户Id值") @RequestParam(name = "userId") Integer userId){
        RestMessage<User> restMessage = new RestMessage<>();
        userService.deleteUserById(userId);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }

    @ApiOperation(value = "增加一个新用户", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/addOneUser", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<User> addOneUser(
            @ApiParam(name = "userId", required = true, value = "用户Id值") @RequestParam(name = "userId") Integer userId,
            @ApiParam(name = "name", required = true, value = "姓名") @RequestParam(name = "name") String name,
            @ApiParam(name = "depId", required = true, value = "部门Id") @RequestParam(name = "depId") String depId,
            @ApiParam(name = "sex", required = true, value = "性别") @RequestParam(name = "sex") String sex
            ){
        RestMessage<User> restMessage = new RestMessage<>();
        userService.addOneUser(userId, name, depId, sex);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }
}
