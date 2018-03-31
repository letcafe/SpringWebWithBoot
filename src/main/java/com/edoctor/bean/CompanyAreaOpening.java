package com.edoctor.bean;

import javax.persistence.*;

@Entity
@Table(name = "company_area_opening")
public class CompanyAreaOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String company_name;
    String area_name;

    public CompanyAreaOpening() {
    }

    public CompanyAreaOpening(String company_name, String area_name) {
        this.company_name = company_name;
        this.area_name = area_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CompanyAreaOpening{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", area_name='" + area_name + '\'' +
                '}';
    }
}
