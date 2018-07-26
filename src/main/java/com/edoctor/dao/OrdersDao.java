package com.edoctor.dao;

import com.edoctor.bean.Orders;

public interface OrdersDao {
    void save(Orders order);

    Orders selectByPrimaryKey(String orderId);

    void updateByPrimaryKeySelective(Orders order);
}
