package com.edoctor.service.impl;

import com.edoctor.bean.StompBean;
import com.edoctor.service.StompBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class StompBeanServiceImpl implements StompBeanService {

    private SimpMessageSendingOperations simpMessageSendingOperations;

    @Autowired
    public StompBeanServiceImpl(SimpMessageSendingOperations simpMessageSendingOperations) {
        this.simpMessageSendingOperations = simpMessageSendingOperations;
    }

    @Override
    public void broadcastStompBean(StompBean stompBean) {
        simpMessageSendingOperations.convertAndSend("/topic/macro2", stompBean);
    }
}
