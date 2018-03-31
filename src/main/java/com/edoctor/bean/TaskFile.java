package com.edoctor.bean;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task_upload_file")
public class TaskFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double task_id;
    String fileType;
    String fileName;
    Double size;
    Timestamp uploadTime;
    String path;
    Integer employee_id;

    public TaskFile() {
    }

    public TaskFile(Double task_id, String fileType, String fileName, Double size, Timestamp uploadTime, String path, Integer employee_id) {
        this.task_id = task_id;
        this.fileType = fileType;
        this.fileName = fileName;
        this.size = size;
        this.uploadTime = uploadTime;
        this.path = path;
        this.employee_id = employee_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTask_id() {
        return task_id;
    }

    public void setTask_id(Double task_id) {
        this.task_id = task_id;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "TaskFile{" +
                "id=" + id +
                ", task_id=" + task_id +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", size=" + size +
                ", uploadTime=" + uploadTime +
                ", path='" + path + '\'' +
                ", employee_id=" + employee_id +
                '}';
    }
}
