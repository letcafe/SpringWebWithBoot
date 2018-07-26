package com.edoctor.dao.impl;

import com.edoctor.bean.Orders;
import com.edoctor.dao.OrdersDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    private static String selectByPrimaryKey = "SELECT * FROM orders WHERE id = :id";


    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Orders order) {
        currentSession().save(order);
    }

    @Override
    public Orders selectByPrimaryKey(String orderId) {
        Query<Orders> query = currentSession().createNativeQuery(selectByPrimaryKey, Orders.class);
        query.setParameter("id", orderId);
        return query.getSingleResult();
    }

    @Override
    public void updateByPrimaryKeySelective(Orders order) {
        currentSession().update(order);
    }
}
