package com.edoctor.bean;

import javax.persistence.*;

@Entity
@Table(name = "area_admin")
public class AreaAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    Integer area_admin_id;
    String name;
    String phone_number;
    String password;
    String area_name;
    String api_key;

    public AreaAdmin() {
    }

    public AreaAdmin(Integer area_admin_id, String name, String phone_number, String password, String area_name, String api_key) {
        this.area_admin_id = area_admin_id;
        this.name = name;
        this.phone_number = phone_number;
        this.password = password;
        this.area_name = area_name;
        this.api_key = api_key;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getArea_admin_id() {
        return area_admin_id;
    }

    public void setArea_admin_id(Integer area_admin_id) {
        this.area_admin_id = area_admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "AreaAdmin{" +
                "Id=" + Id +
                ", area_admin_id=" + area_admin_id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                ", area_name='" + area_name + '\'' +
                ", api_key='" + api_key + '\'' +
                '}';
    }
}
