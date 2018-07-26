package com.edoctor.controller;

import com.edoctor.bean.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConsumeMQController {
    Logger LOG = LogManager.getLogger(ConsumeMQController.class);

    void printStringValue(User msg) {
        System.out.println("print a str value");
        System.out.println(msg.toString());
        LOG.info("printStringValue");
    }

}
