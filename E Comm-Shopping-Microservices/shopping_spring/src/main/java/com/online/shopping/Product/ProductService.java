package com.online.shopping.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService{

    @Autowired
    ProductDataHandler productDataHandler;

    public Product searchById(int id){
        return productDataHandler.findById(id).get();
    }

    public List<Product> searchByName(String name, int page, int offset){
        return productDataHandler.searchProductByName(name,PageRequest.of(page,offset));
    }

    public List<Product> searchByCategory(int category, int page, int offset){
        return productDataHandler.searchProductByCategory(category,PageRequest.of(page,offset));
    }

}
