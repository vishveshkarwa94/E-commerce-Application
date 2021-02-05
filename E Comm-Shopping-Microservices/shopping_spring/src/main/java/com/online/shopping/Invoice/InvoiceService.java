package com.online.shopping.Invoice;

import com.online.shopping.Invoice.Cart.Cart;
import com.online.shopping.Invoice.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class InvoiceService{

    @Autowired
    InvoiceDataHandler invoiceDataHandler;

    @Autowired
    InvoiceDetailsDataHandler invoiceDetailsDataHandler;

    @Autowired
    CartService cartService;

    public List<Invoice> getAllInvoices(int customerId){
        return invoiceDataHandler.getAllOrders(customerId);
    }

    public List<InvoiceDetails> getInvoiceDetail(int invoiceId){
        return invoiceDetailsDataHandler.getDetails(invoiceId);
    }

    public int checkOut( int customerId){

        List<Cart> allItems = cartService.getAllCartItems(customerId);

        if(allItems.size() == 0){
            return -1;
        }

        int total = 0;
        for(Cart cart: allItems){
            int qty = cart.getQty();
            int price = cart.getPrice();
            total += (qty * price);
        }

        Invoice invoice = new Invoice(customerId, new Date(System.currentTimeMillis()), total);
        invoice = invoiceDataHandler.save(invoice);
        int invoiceId = invoice.getId();

        for(Cart cart: allItems){
            int prodId = cart.getProd_id();
            int qty = cart.getQty();
            int price = cart.getPrice();
            InvoiceDetails invoiceDetails = new InvoiceDetails(invoiceId, prodId, qty, qty * price);
            invoiceDetailsDataHandler.save(invoiceDetails);
        }

        cartService.deleteAll(customerId);

        return invoiceId;

    }

}
