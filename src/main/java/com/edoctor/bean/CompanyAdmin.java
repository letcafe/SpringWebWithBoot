package com.edoctor.bean;

import javax.persistence.*;

@Entity
@Table(name = "company_admin")
public class CompanyAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer company_admin_id;
    String phone_number;
    String password;
    String name;
    String company_name;
    String area_name;
    String api_key;

    public CompanyAdmin() {
    }

    public CompanyAdmin(Integer company_admin_id, String phone_number, String password, String name, String company_name, String area_name, String api_key) {
        this.company_admin_id = company_admin_id;
        this.phone_number = phone_number;
        this.password = password;
        this.name = name;
        this.company_name = company_name;
        this.area_name = area_name;
        this.api_key = api_key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompany_admin_id() {
        return company_admin_id;
    }

    public void setCompany_admin_id(Integer company_admin_id) {
        this.company_admin_id = company_admin_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    @Override
    public String toString() {
        return "CompanyAdmin{" +
                "id=" + id +
                ", company_admin_id=" + company_admin_id +
                ", phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", company_name='" + company_name + '\'' +
                ", area_name='" + area_name + '\'' +
                ", api_key='" + api_key + '\'' +
                '}';
    }
}
