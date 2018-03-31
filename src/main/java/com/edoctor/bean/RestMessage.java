package com.edoctor.bean;

public class RestMessage<T> {
    int code;
    String msg;
    T data;

    public RestMessage() {
    }

    public RestMessage(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public RestMessage<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RestMessage<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RestMessage<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "RestMessage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
