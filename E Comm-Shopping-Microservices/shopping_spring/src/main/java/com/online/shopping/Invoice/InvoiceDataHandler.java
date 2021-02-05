package com.online.shopping.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDataHandler extends JpaRepository<Invoice, Integer> {

    @Query("SELECT i FROM invoice i WHERE i.cust_id = ?1")
    public List<Invoice> getAllOrders(int customerId);

}
