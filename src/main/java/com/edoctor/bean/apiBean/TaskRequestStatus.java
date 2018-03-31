package com.edoctor.bean.apiBean;

public class TaskRequestStatus {
    Integer notCommit;
    Integer requesting;
    Integer notApprove;
    Integer approve;

    public TaskRequestStatus(Integer notCommit, Integer requesting, Integer notApprove, Integer approve) {
        this.notCommit = notCommit;
        this.requesting = requesting;
        this.notApprove = notApprove;
        this.approve = approve;
    }

    public Integer getNotCommit() {
        return notCommit;
    }

    public void setNotCommit(Integer notCommit) {
        this.notCommit = notCommit;
    }

    public Integer getRequesting() {
        return requesting;
    }

    public void setRequesting(Integer requesting) {
        this.requesting = requesting;
    }

    public Integer getNotApprove() {
        return notApprove;
    }

    public void setNotApprove(Integer notApprove) {
        this.notApprove = notApprove;
    }

    public Integer getApprove() {
        return approve;
    }

    public void setApprove(Integer approve) {
        this.approve = approve;
    }

    @Override
    public String toString() {
        return "TaskRequestStatus{" +
                "notCommit=" + notCommit +
                ", requesting=" + requesting +
                ", notApprove=" + notApprove +
                ", approve=" + approve +
                '}';
    }
}
