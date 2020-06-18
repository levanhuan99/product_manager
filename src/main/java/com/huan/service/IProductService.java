package com.huan.service;

import com.huan.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    Product getProductById(int id);
    void save(Product product);
    void update(Product product);
    void remove(int id);


}
