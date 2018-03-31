package com.edoctor.bean.apiBean;

import java.sql.Timestamp;

public class EmployeeLocation {
    Integer employee_id;
    Double lng;
    Double lat;
    Timestamp updateTime;

    public EmployeeLocation(Integer employee_id, Double lng, Double lat, Timestamp updateTime) {
        this.employee_id = employee_id;
        this.lng = lng;
        this.lat = lat;
        this.updateTime = updateTime;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "EmployeeLocation{" +
                "employee_id=" + employee_id +
                ", lng=" + lng +
                ", lat=" + lat +
                ", updateTime=" + updateTime +
                '}';
    }
}
