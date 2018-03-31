package com.edoctor.bean;

import com.edoctor.enums.LOG_TYPE;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.LinkedHashMap;

@Document
public class DeviceLog {

    @Id
    String id;
    String deviceId;
    String deviceType;
    String serviceType;
    String serviceId;
    LinkedHashMap<String, String> data;
    Long eventTime;
    String serviceInfo;
    LOG_TYPE log_type;

    public DeviceLog(String deviceId, String deviceType, String serviceType, String serviceId, LinkedHashMap<String, String> data, Long eventTime, String serviceInfo, LOG_TYPE log_type) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.serviceType = serviceType;
        this.serviceId = serviceId;
        this.data = data;
        this.eventTime = eventTime;
        this.serviceInfo = serviceInfo;
        this.log_type = log_type;
    }

    public DeviceLog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public LinkedHashMap<String, String> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, String> data) {
        this.data = data;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public LOG_TYPE getLog_type() {
        return log_type;
    }

    public void setLog_type(LOG_TYPE log_type) {
        this.log_type = log_type;
    }

    @Override
    public String toString() {
        return "DeviceLog{" +
                "id='" + id + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", data=" + data +
                ", eventTime=" + eventTime +
                ", serviceInfo='" + serviceInfo + '\'' +
                ", log_type=" + log_type +
                '}';
    }
}
