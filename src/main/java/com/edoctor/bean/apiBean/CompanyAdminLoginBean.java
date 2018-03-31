package com.edoctor.bean.apiBean;

import com.edoctor.bean.CompanyAdmin;

public class CompanyAdminLoginBean {
    CompanyAdmin companyAdmin;
    String token;

    public CompanyAdminLoginBean() {
    }

    public CompanyAdminLoginBean(CompanyAdmin companyAdmin, String token) {
        this.companyAdmin = companyAdmin;
        this.token = token;
    }

    public CompanyAdmin getCompanyAdmin() {
        return companyAdmin;
    }

    public void setCompanyAdmin(CompanyAdmin companyAdmin) {
        this.companyAdmin = companyAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CompanyAdminLoginBean{" +
                "companyAdmin=" + companyAdmin +
                ", token='" + token + '\'' +
                '}';
    }
}
