package com.online.shopping.Invoice.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService{

    @Autowired
    CartDataHandler cartDataHandler;

    public int addItem(Cart cart){
        Cart cartRes = cartDataHandler.save(cart);
        return cartRes.getId();
    }

    public List<Cart> getAllCartItems(int custId){
        return cartDataHandler.allCart(custId);
    }

    public void deleteAll(int custId){
        List<Cart> allItems = getAllCartItems(custId);
            cartDataHandler.deleteAll(allItems);
    }

    public void deleteOne(int id){ cartDataHandler.deleteById(id); }

}
