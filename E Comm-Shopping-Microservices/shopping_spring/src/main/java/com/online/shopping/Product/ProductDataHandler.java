package com.online.shopping.Product;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDataHandler extends JpaRepository<Product,Integer> {


    @Query("SELECT p FROM products p WHERE p.product_name LIKE %?1% ORDER BY p.product_name")
    public List<Product> searchProductByName(String name, Pageable pageable);

    @Query("SELECT p FROM products p WHERE p.product_category = ?1 ORDER BY p.product_name")
    public List<Product> searchProductByCategory(int category, Pageable pageable);

}
