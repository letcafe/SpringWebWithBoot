package com.edoctor.dao.impl;

import com.edoctor.bean.Product;
import com.edoctor.dao.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static final String selectAll = "SELECT * FROM product";

    private static final String selectByPrimaryKey = "SELECT * FROM product WHERE id = :id";

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product selectByPrimaryKey(String productId) {
        Query<Product> query = currentSession().createNativeQuery(selectByPrimaryKey, Product.class);
        query.setParameter("id", productId);
        return query.getSingleResult();
    }

    @Override
    public List<Product> selectAll() {
        Query<Product> query = currentSession().createNativeQuery(selectAll, Product.class);
        return query.getResultList();
    }
}
