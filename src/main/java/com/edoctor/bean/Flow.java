package com.edoctor.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flow")
public class Flow {

    @Id
    @Column(name="id")
    private String id;
    @Column(name="flow_num")
    private String flowNum;
    @Column(name="order_num")
    private String orderNum;
    @Column(name="product_id")
    private String productId;
    @Column(name="paid_amount")
    private String paidAmount;
    @Column(name="paid_method")
    private Integer paidMethod;
    @Column(name="buy_counts")
    private Integer buyCounts;
    @Column(name="create_time")
    private Date createTime;

    public Flow() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum == null ? null : flowNum.trim();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount == null ? null : paidAmount.trim();
    }

    public Integer getPaidMethod() {
        return paidMethod;
    }

    public void setPaidMethod(Integer paidMethod) {
        this.paidMethod = paidMethod;
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}