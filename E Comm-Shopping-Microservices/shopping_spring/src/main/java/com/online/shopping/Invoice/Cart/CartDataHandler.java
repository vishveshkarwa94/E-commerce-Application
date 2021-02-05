package com.online.shopping.Invoice.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDataHandler extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM cart c WHERE c.cust_id = ?1")
    public List<Cart> allCart(int custId);

}
