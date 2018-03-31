package com.edoctor.bean;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    /**
     * 判断非空未实现，需要下一步使用hibernate支持实现判断
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer employee_id;
    String name;
    String company_name;
    String area_name;
    String phone_number;
    String password;
    String IMEI;
    String api_key;

    public Employee() {
    }

    public Employee(Integer employee_id, String name, String company_name, String area_name, String phone_number, String password, String IMEI, String api_key) {
        this.employee_id = employee_id;
        this.name = name;
        this.company_name = company_name;
        this.area_name = area_name;
        this.phone_number = phone_number;
        this.password = password;
        this.IMEI = IMEI;
        this.api_key = api_key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
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

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employee_id=" + employee_id +
                ", name='" + name + '\'' +
                ", company_name='" + company_name + '\'' +
                ", area_name='" + area_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                ", IMEI='" + IMEI + '\'' +
                ", api_key='" + api_key + '\'' +
                '}';
    }
}
