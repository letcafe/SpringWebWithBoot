package com.edoctor.service.impl;

import com.edoctor.bean.Product;
import com.edoctor.dao.ProductDao;
import com.edoctor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {

        Product pe = new Product();
        List<Product> list = productDao.selectAll();

        return list;
    }

    @Override
    public Product getProductById(String productId) {

        return productDao.selectByPrimaryKey(productId);
    }

}
