package com.online.shopping.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDataHandler extends JpaRepository<Customer, Integer> {

    @Query("SELECT c from customer c WHERE c.email = ?1")
    public Customer checkIfExist(String email);
}
