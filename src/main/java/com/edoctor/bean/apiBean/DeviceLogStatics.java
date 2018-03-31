package com.edoctor.bean.apiBean;

public class DeviceLogStatics {
    Long errorNum;
    Long warnNum;
    Long infoNum;

    public DeviceLogStatics() {
    }

    public DeviceLogStatics(Long errorNum, Long warnNum, Long infoNum) {
        this.errorNum = errorNum;
        this.warnNum = warnNum;
        this.infoNum = infoNum;
    }

    public Long getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Long errorNum) {
        this.errorNum = errorNum;
    }

    public Long getWarnNum() {
        return warnNum;
    }

    public void setWarnNum(Long warnNum) {
        this.warnNum = warnNum;
    }

    public Long getInfoNum() {
        return infoNum;
    }

    public void setInfoNum(Long infoNum) {
        this.infoNum = infoNum;
    }

    @Override
    public String toString() {
        return "DeviceLogStatics{" +
                "errorNum=" + errorNum +
                ", warnNum=" + warnNum +
                ", infoNum=" + infoNum +
                '}';
    }
}
