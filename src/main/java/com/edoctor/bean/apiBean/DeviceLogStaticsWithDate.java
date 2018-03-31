package com.edoctor.bean.apiBean;

public class DeviceLogStaticsWithDate {

    Integer year;
    Integer month;
    Integer day;
    DeviceLogStatics deviceLogStatics;

    public DeviceLogStaticsWithDate() {
    }

    public DeviceLogStaticsWithDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DeviceLogStaticsWithDate(Integer year, Integer month, Integer day, DeviceLogStatics deviceLogStatics) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.deviceLogStatics = deviceLogStatics;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public DeviceLogStatics getDeviceLogStatics() {
        return deviceLogStatics;
    }

    public void setDeviceLogStatics(DeviceLogStatics deviceLogStatics) {
        this.deviceLogStatics = deviceLogStatics;
    }

    @Override
    public String toString() {
        return "DeviceLogStaticsWithDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", deviceLogStatics=" + deviceLogStatics +
                '}';
    }
}
