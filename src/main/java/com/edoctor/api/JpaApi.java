package com.edoctor.api;

import com.edoctor.bean.Device;
import com.edoctor.bean.RestMessage;
import com.edoctor.service.DeviceService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Api(value = "JPA操作API")
@RestController
@RequestMapping("/api/v1/jpa/operation")
public class JpaApi {

    @Autowired
    DeviceService deviceService;

    @ApiOperation(value = "选出区域内所有的设备", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mq server down", response = RestMessage.class)
    })
    @RequestMapping(value = "listDeviceByArea", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<List<Device>> listDeviceByArea(
            @ApiParam(name = "area", required = true, value = "区域名称") @RequestParam(value = "area") String area) {
        RestMessage<List<Device>> restMessage = new RestMessage<>();
        List<Device> deviceList = deviceService.getDevicesByArea(area);
        restMessage.setCode(200).setMsg("success: successfully").setData(deviceList);
        return restMessage;
    }

    @ApiOperation(value = "获得设备数量", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mq server down", response = RestMessage.class)
    })
    @RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<Long> count() {
        RestMessage<Long> restMessage = new RestMessage<>();
        Long count = deviceService.count();
        restMessage.setCode(200).setMsg("success: successfully").setData(count);
        return restMessage;
    }

    @ApiOperation(value = "插入一个新设备", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mq server down", response = RestMessage.class)
    })
    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<Device> save(
            @ApiParam(name = "name", required = true, value = "名称") @RequestParam(value = "name") String name,
            @ApiParam(name = "area", required = true, value = "区域名称") @RequestParam(value = "area") String area
            ) {
        RestMessage<Device> restMessage = new RestMessage<>();
        Device device = new Device();
        device.setName(name);
        device.setArea(area);
        Device deviceAfterInsert = deviceService.save(device);
        restMessage.setCode(200).setMsg("success: successfully").setData(deviceAfterInsert);
        return restMessage;
    }

    @ApiOperation(value = "根据Id读取内容,用于测试连接池的效能", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mq server down", response = RestMessage.class)
    })
    @RequestMapping(value = "getRandomDeviceById", method = RequestMethod.GET, produces = "application/json")
    public RestMessage<String> getRandomDeviceById() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        RestMessage<String> restMessage = new RestMessage<>();

        Thread[] threads = new Thread[8];

        for(int i = 0; i < threads.length; i ++) {
            threads[i] = new Thread(() -> {
                int queryCount = 0;
                for(int j = 0; j < 1000; j ++) {
                    int randomIndex = new Random().nextInt(150000) + 10000;
                    Device device = deviceService.getDeviceById(randomIndex);
                    queryCount ++;
                }
                System.out.println("query count:" + queryCount);
            } , "Thread[" + i + "]");
            threads[i].start();
            threads[i].join();
        }
        long costTime = System.currentTimeMillis() - startTime;
        restMessage.setCode(200).setMsg("success: successfully").setData("cost time : " + costTime + " ms");
        return restMessage;
    }
}
