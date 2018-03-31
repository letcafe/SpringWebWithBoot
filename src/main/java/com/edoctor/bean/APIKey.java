package com.edoctor.bean;


import javax.persistence.*;

@Entity
@Table(name = "api")
public class APIKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "api_key")
    String api_key;
    @Column(name = "permission_level")
    int permission_level;

    public APIKey() {
    }

    public APIKey(String api_key, int permission_level) {
        this.api_key = api_key;
        this.permission_level = permission_level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public int getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(int permission_level) {
        this.permission_level = permission_level;
    }

    @Override
    public String toString() {
        return "APIKey{" +
                "id=" + id +
                ", api_key='" + api_key + '\'' +
                ", permission_level=" + permission_level +
                '}';
    }
}
