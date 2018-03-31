package com.edoctor.bean.apiBean;

public class TaskStatics {

    int employee_id;
    String area;
    int finished_task_num;
    int normal_task_num;
    int urgent_task_num;
    int overtime_task_num;
    int total_task_count;

    public TaskStatics() {
    }

    public TaskStatics(int employee_id, String area, int finished_task_num, int normal_task_num, int urgent_task_num, int overtime_task_num, int total_task_count) {
        this.employee_id = employee_id;
        this.area = area;
        this.finished_task_num = finished_task_num;
        this.normal_task_num = normal_task_num;
        this.urgent_task_num = urgent_task_num;
        this.overtime_task_num = overtime_task_num;
        this.total_task_count = total_task_count;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getFinished_task_num() {
        return finished_task_num;
    }

    public void setFinished_task_num(int finished_task_num) {
        this.finished_task_num = finished_task_num;
    }

    public int getNormal_task_num() {
        return normal_task_num;
    }

    public void setNormal_task_num(int normal_task_num) {
        this.normal_task_num = normal_task_num;
    }

    public int getUrgent_task_num() {
        return urgent_task_num;
    }

    public void setUrgent_task_num(int urgent_task_num) {
        this.urgent_task_num = urgent_task_num;
    }

    public int getOvertime_task_num() {
        return overtime_task_num;
    }

    public void setOvertime_task_num(int overtime_task_num) {
        this.overtime_task_num = overtime_task_num;
    }

    public int getTotal_task_count() {
        return total_task_count;
    }

    public void setTotal_task_count(int total_task_count) {
        this.total_task_count = total_task_count;
    }

    @Override
    public String toString() {
        return "TaskStatics{" +
                "employee_id=" + employee_id +
                ", area='" + area + '\'' +
                ", finished_task_num=" + finished_task_num +
                ", normal_task_num=" + normal_task_num +
                ", urgent_task_num=" + urgent_task_num +
                ", overtime_task_num=" + overtime_task_num +
                ", total_task_count=" + total_task_count +
                '}';
    }
}
