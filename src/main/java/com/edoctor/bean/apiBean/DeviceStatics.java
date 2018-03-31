package com.edoctor.bean.apiBean;

public class DeviceStatics {
    Integer owner_id;
    String area;
    String company_name;
    Integer normal_device_num;
    Integer info_device_num;
    Integer danger_device_num;
    Integer total_device_num;

    public DeviceStatics() {
    }

    public DeviceStatics(Integer owner_id, String area, String company_name, Integer normal_device_num, Integer info_device_num, Integer danger_device_num, Integer total_device_num) {
        this.owner_id = owner_id;
        this.area = area;
        this.company_name = company_name;
        this.normal_device_num = normal_device_num;
        this.info_device_num = info_device_num;
        this.danger_device_num = danger_device_num;
        this.total_device_num = total_device_num;
    }

    public Integer getNormal_device_num() {
        return normal_device_num;
    }

    public void setNormal_device_num(Integer normal_device_num) {
        this.normal_device_num = normal_device_num;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Integer getInfo_device_num() {
        return info_device_num;
    }

    public void setInfo_device_num(Integer info_device_num) {
        this.info_device_num = info_device_num;
    }

    public Integer getDanger_device_num() {
        return danger_device_num;
    }

    public void setDanger_device_num(Integer danger_device_num) {
        this.danger_device_num = danger_device_num;
    }

    public Integer getTotal_device_num() {
        return total_device_num;
    }

    public void setTotal_device_num(Integer total_device_num) {
        this.total_device_num = total_device_num;
    }

    @Override
    public String toString() {
        return "DeviceStatics{" +
                "owner_id=" + owner_id +
                ", area='" + area + '\'' +
                ", company_name='" + company_name + '\'' +
                ", normal_device_num=" + normal_device_num +
                ", info_device_num=" + info_device_num +
                ", danger_device_num=" + danger_device_num +
                ", total_device_num=" + total_device_num +
                '}';
    }
}
