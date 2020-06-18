package com.huan.service;

import com.huan.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    private  List<Product> list;
    private static ProductService productService;
    private ProductService(){
        list=new ArrayList<>();
        list.add(new Product(1,"product1",1000,"good"));
        list.add(new Product(2,"product2",2000,"good"));
        list.add(new Product(3,"product3",3000,"good"));
        list.add(new Product(4,"product4",4000,"good"));
        list.add(new Product(6,"product5",5000,"good"));
        list.add(new Product(7,"product6",6000,"good"));
        list.add(new Product(8,"product7",7000,"good"));
    }


    public static ProductService getProductService(){
        if (productService==null){
           productService=  new ProductService();
        }
        return productService;
    }

    @Override
    public List<Product> getAllProduct() {
        return list;
    }

    @Override
    public Product getProductById(int id) {
        for (int i=0;i<list.size();i++){
            if (list.get(i).getId()==id){
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        list.add(product);
    }

    @Override
    public void update( Product product) {
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getId() == product.getId()) {
                list.get(i).setId(product.getId());
                list.get(i).setName(product.getName());
                list.get(i).setPrice(product.getPrice());
                list.get(i).setDescription(product.getDescription());
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getId() == id) {
                list.remove(list.get(i));
            }
        }
    }
}
