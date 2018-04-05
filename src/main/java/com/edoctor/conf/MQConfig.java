package com.edoctor.conf;

import com.edoctor.bean.Employee;
import com.edoctor.controller.ConsumeMQController;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MQConfig {

    // 配置MQ连接工厂信息
    private ActiveMQConnectionFactory getAMQFactory() {
        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory();
        mqConnectionFactory.setBrokerURL("tcp://59.110.231.87:61616");
        mqConnectionFactory.setTrustedPackages(Arrays.asList("com.edoctor.bean"));
        return mqConnectionFactory;
    }

    // 将连接工厂注入，生成池化的带有异步的Pool
    @Bean
    public PooledConnectionFactory pooledConnectionFactory() {
        PooledConnectionFactory connectionFactory = new PooledConnectionFactory();
        connectionFactory.setConnectionFactory(getAMQFactory());
        connectionFactory.setUseAnonymousProducers(true);
        return connectionFactory;
    }

    // 生成JMS消息访问的模板类，使用JmsOperations简化消息的生成和读取
    @Bean
    public JmsTemplate getJmsTemplate(PooledConnectionFactory cf) {
        JmsTemplate jmsTemplate = new JmsTemplate(cf);
        jmsTemplate.setDefaultDestinationName("EDoctor.JMSTemplate.queue3");
        jmsTemplate.setMessageConverter(getJacksonMessageConverter());
        // pubSubDomain = true 为队列模式，false为订阅发布模式
        jmsTemplate.setPubSubDomain(false);
        return jmsTemplate;
    }

    //设置发送和接受的转换器为MappingJackson2MessageConverter
    private MappingJackson2MessageConverter getJacksonMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        Map<String, Class<?>> typeIdMap = new HashMap<>();
        typeIdMap.put("Employee", Employee.class);
        converter.setTypeIdMappings(typeIdMap);
        converter.setTypeIdPropertyName("Employee");
        converter.setEncoding("UTF-8");
        return converter;
    }

    // 异步接受消息的消息监听器-适配器，这个为异步监听接受的处理方法以及类名称。同时使用Jackson2解序列化，解析对象进行处理
    @Bean
    MessageListenerAdapter messageListenerAdapter() {
        MessageListenerAdapter adapter = new MessageListenerAdapter();
        adapter.setMessageConverter(getJacksonMessageConverter());
        adapter.setDelegate(new ConsumeMQController());
        adapter.setDefaultListenerMethod("printStringValue");
        return adapter;
    }

    // 异步接受消息的消息监听器-容器
    @Bean
    DefaultMessageListenerContainer defaultMessageListenerContainer(PooledConnectionFactory connectionFactory, MessageListenerAdapter adapter) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestinationName("EDoctor.JMSTemplate.queue3");
        container.setMessageListener(adapter);
        //设置接受MQ消息的事物性回滚
        container.setSessionTransacted(true);
        return container;
    }
}
