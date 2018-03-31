package com.edoctor.bean;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task_detail")
public class TaskDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double task_id;
    Integer receiver;
    Timestamp start_time;
    String description;
    Integer status;
    Timestamp complete_time;
    String sender;
    Timestamp deadline_time;
    String reply_title;
    String reply_content;
    Boolean is_requesting;
    Boolean is_pass;

    public TaskDetail() {
    }

    public TaskDetail(Double task_id, Integer receiver, Timestamp start_time, String description, Integer status, Timestamp complete_time, String sender, Timestamp deadline_time, String reply_title, String reply_content, Boolean is_requesting, Boolean is_pass) {
        this.task_id = task_id;
        this.receiver = receiver;
        this.start_time = start_time;
        this.description = description;
        this.status = status;
        this.complete_time = complete_time;
        this.sender = sender;
        this.deadline_time = deadline_time;
        this.reply_title = reply_title;
        this.reply_content = reply_content;
        this.is_requesting = is_requesting;
        this.is_pass = is_pass;
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

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(Timestamp complete_time) {
        this.complete_time = complete_time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Timestamp getDeadline_time() {
        return deadline_time;
    }

    public void setDeadline_time(Timestamp deadline_time) {
        this.deadline_time = deadline_time;
    }

    public String getReply_title() {
        return reply_title;
    }

    public void setReply_title(String reply_title) {
        this.reply_title = reply_title;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public Boolean getIs_requesting() {
        return is_requesting;
    }

    public void setIs_requesting(Boolean is_requesting) {
        this.is_requesting = is_requesting;
    }

    public Boolean getIs_pass() {
        return is_pass;
    }

    public void setIs_pass(Boolean is_pass) {
        this.is_pass = is_pass;
    }

    @Override
    public String toString() {
        return "TaskDetail{" +
                "id=" + id +
                ", task_id=" + task_id +
                ", receiver=" + receiver +
                ", start_time=" + start_time +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", complete_time=" + complete_time +
                ", sender='" + sender + '\'' +
                ", deadline_time=" + deadline_time +
                ", reply_title='" + reply_title + '\'' +
                ", reply_content='" + reply_content + '\'' +
                ", is_requesting=" + is_requesting +
                ", is_pass=" + is_pass +
                '}';
    }
}
