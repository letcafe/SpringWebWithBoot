package com.edoctor.controller;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
public class MBeanTestController {
    public String name;
    public static final Integer DEFAULT_PAGE_SIZE = 25;
    public static Integer pageSize = DEFAULT_PAGE_SIZE;

    public MBeanTestController() {
    }

    public MBeanTestController(String name) {
        this.name = name;
    }

    @ManagedAttribute
    public String getName() {
        return name;
    }

    @ManagedAttribute
    public void setName(String name) {
        this.name = name;
    }

    @ManagedAttribute
    public Integer getPageSize() {
        return pageSize;
    }

    public static Integer getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "MBeanTestController{" +
                "name='" + name + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
