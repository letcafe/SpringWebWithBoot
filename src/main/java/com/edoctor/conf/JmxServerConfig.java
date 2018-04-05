package com.edoctor.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.assembler.MetadataMBeanInfoAssembler;
import org.springframework.jmx.export.naming.MetadataNamingStrategy;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

@Configuration
public class JmxServerConfig {

    // 创建MBean的Bean工厂
    @Bean
    public MBeanServerFactoryBean mBeanServerFactoryBean() {
        MBeanServerFactoryBean mBeanServer = new MBeanServerFactoryBean();
        mBeanServer.setLocateExistingServerIfPossible(true);
        return mBeanServer;
    }

    // 定义MBean的Bean导出器
    @Bean
    public MBeanExporter mBeanExporter() {
        MBeanExporter mBeanExporter = new MBeanExporter();
        mBeanExporter.setNamingStrategy(metadataNamingStrategy());
        mBeanExporter.setAssembler(metadataMBeanInfoAssembler());
        // 当MBean命名冲突时，覆盖原来的MBean
        mBeanExporter.setRegistrationPolicy(RegistrationPolicy.REPLACE_EXISTING);
        return mBeanExporter;
    }

    // 配置注解驱动的MBean，使其只暴露指定属性方法1
    private AnnotationJmxAttributeSource annotationJmxAttributeSource() {
        return new AnnotationJmxAttributeSource();
    }

    // 配置注解驱动的MBean，使其只暴露指定属性方法2
    private MetadataMBeanInfoAssembler metadataMBeanInfoAssembler() {
        MetadataMBeanInfoAssembler assembler = new MetadataMBeanInfoAssembler();
        assembler.setAttributeSource(annotationJmxAttributeSource());
        return assembler;
    }

    // 配置注解驱动的MBean，使其只暴露指定属性方法3
    private MetadataNamingStrategy metadataNamingStrategy() {
        MetadataNamingStrategy namingStrategy = new MetadataNamingStrategy();
        namingStrategy.setAttributeSource(annotationJmxAttributeSource());
        return namingStrategy;
    }

    // 此定义RmiRegistryFactoryBean的方法必须谜一样的位于ConnectorServerFactoryBean构造的上方
    @Bean
    public RmiRegistryFactoryBean factoryBean() {
        RmiRegistryFactoryBean rmiRegistryFB = new RmiRegistryFactoryBean();
        rmiRegistryFB.setPort(1099);
        return rmiRegistryFB;
    }

    // 将MBean暴露为远程MBean，注释该方法后将监听暴露给本地MBean
    @Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean() {
        ConnectorServerFactoryBean factoryBean = new ConnectorServerFactoryBean();
        factoryBean.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/SpringWebWithBoot");
        return factoryBean;
    }


}
