package com.edoctor.service;

import com.edoctor.bean.StompBean;

public interface StompBeanService {

    void broadcastStompBean(StompBean stompBean);
}
