package com.online.shopping.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailsDataHandler extends JpaRepository<InvoiceDetails, Integer> {

    @Query("SELECT i FROM invoice_details i WHERE i.invoice_id = ?1")
    public List<InvoiceDetails> getDetails(int invoiceId);
}
