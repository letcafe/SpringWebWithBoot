package com.edoctor.controller;

import com.edoctor.bean.StompBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    private static final Logger LOG = LoggerFactory.getLogger(StompController.class);

    @MessageMapping("/macro")
//    @SendTo("/queue/shout")
    public StompBean handleShout(StompBean incoming) {
        LOG.info("Received messagesssss:" + incoming.getMessage());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        incoming.setMessage(incoming.getMessage() + "Polo!");
        return incoming;
    }

}
