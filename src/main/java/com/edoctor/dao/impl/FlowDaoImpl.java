package com.edoctor.dao.impl;

import com.edoctor.bean.Flow;
import com.edoctor.dao.FlowDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FlowDaoImpl implements FlowDao {

    @Autowired
    SessionFactory sessionFactory;

    Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void save(Flow flow) {
        currentSession().save(flow);
    }
}
