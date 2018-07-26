package com.edoctor.dao.impl;

import com.edoctor.bean.User;
import com.edoctor.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String deleteByPrimaryKey = "DELETE FROM user WHERE id=:userId";

    private static final String selectByPrimaryKey = "SELECT *  FROM user WHERE id=:userId";

    private static final String getUserList = "SELECT *  FROM user";

    private static final String count = "SELECT COUNT(*)  FROM user";


    @Autowired
    SessionFactory sessionFactory;

    Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(User user) {
        currentSession().save(user);
    }

    @Override
    public void updateByPrimaryKeySelective(User user) {
        currentSession().update(user);
    }

    @Override
    public void deleteByPrimaryKey(String userId) {
        Query query = currentSession().createNativeQuery(deleteByPrimaryKey);
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public User selectByPrimaryKey(String userId) {
        Query<User> query = currentSession().createNativeQuery(selectByPrimaryKey, User.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    @Override
    public List<User> getUserList() {
        Query<User> query = currentSession().createNativeQuery(getUserList, User.class);
        return query.getResultList();
    }

    @Override
    public Long count() {
        Query<Long> query = currentSession().createNativeQuery(count, Long.class);
        return query.getSingleResult();
    }
}
