package com.edoctor.bean.apiBean;

import com.edoctor.bean.AreaAdmin;

public class AreaAdminLoginBean {
    AreaAdmin areaAdmin;
    String token;

    public AreaAdminLoginBean() {
    }

    public AreaAdminLoginBean(AreaAdmin areaAdmin, String token) {
        this.areaAdmin = areaAdmin;
        this.token = token;
    }

    public AreaAdmin getAreaAdmin() {
        return areaAdmin;
    }

    public void setAreaAdmin(AreaAdmin areaAdmin) {
        this.areaAdmin = areaAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AreaAdminLoginBean{" +
                "areaAdmin=" + areaAdmin +
                ", token='" + token + '\'' +
                '}';
    }
}
