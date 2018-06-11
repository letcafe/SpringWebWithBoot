package com.edoctor.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestLazyInitBean {

    static Logger logger = LoggerFactory.getLogger(TestLazyInitBean.class);

    public static List<Device> deviceList = new ArrayList<>(200000000);

    static{
        logger.error(TestLazyInitBean.class + " inited");
//        for(int i = 0; i < deviceList.size(); i ++) {
//            deviceList.set(i, new Device("2112", "2323", 12.1, 13.2, 12, "sdsadasd"));
//        }
    }
}
