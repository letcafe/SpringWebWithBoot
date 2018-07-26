package com.edoctor.dao;

import com.edoctor.bean.Product;

import java.util.List;

public interface ProductDao {
    Product selectByPrimaryKey(String productId);

    List<Product> selectAll();
}
