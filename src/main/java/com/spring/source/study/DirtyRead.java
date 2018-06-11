package com.spring.source.study;

import com.edoctor.bean.Device;
import com.edoctor.bean.RestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;


public class DirtyRead {

    static final Logger logger = LoggerFactory.getLogger(DirtyRead.class);

    public void testVarableParam(String... myStrArray) {
        for(String str : myStrArray) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception {
        if(logger.isInfoEnabled()) {
            logger.warn("hello world");
        }

        Resource xmlResource = new ClassPathResource("hello.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(xmlResource);
        Device device = factory.getBean("device", Device.class);
        System.out.println(device);
        List<String> list = new ArrayList<>();
        StringUtils.toStringArray(list);


        Class clazz = Class.forName("com.edoctor.bean.Device");
        Constructor<Device>[] constructors = clazz.getConstructors();
        for(Constructor con : constructors) {
            System.out.println(con);
        }
        Device devices = BeanUtils.instantiateClass(constructors[3], "helloWorldDemo");
        System.out.println("device reflect = " + devices);
        System.out.println("device reflect newInstance = " + constructors[3].newInstance("helloWorrrrrrld"));

        Class clazz1 = Device.class;
        Constructor[] deviceConList = clazz1.getConstructors();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    static int loadBeanDefinitions(Integer[] intValue) {
        int count = 0;
        for(int i = 0; i < intValue.length; i ++) {
            count += loadBeanDefinitions(new Integer[]{intValue[i]});
        }
        return 0;
    }
}
