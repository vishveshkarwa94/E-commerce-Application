package com.online.shopping.Controlers;

import com.online.shopping.Invoice.Cart.Cart;
import com.online.shopping.Invoice.Cart.CartService;
import com.online.shopping.Invoice.Invoice;
import com.online.shopping.Invoice.InvoiceDetails;
import com.online.shopping.Invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    CartService cartService;

    @PostMapping("/add-item-cart")
    public int addItemToCart(@RequestBody Cart cart){
        return cartService.addItem(cart);
    }

    @GetMapping("/get-all-cart-items/{custId}")
    public List<Cart> getAllCartItems(@PathVariable int custId){
        return cartService.getAllCartItems(custId);
    }

    @GetMapping("/delete-all-cart-items/{custId}")
    public void deleteAllCartItems(@PathVariable int custId){
        cartService.deleteAll(custId);
    }

    @GetMapping("/delete-one-cart-item/{cartId}")
    public void deleteOneCartItem(@PathVariable int cartId){
        cartService.deleteOne(cartId);
    }

    @GetMapping("/get-all-invoices/{customerId}")
    public List<Invoice> getAllInvoices(@PathVariable int customerId){
        return invoiceService.getAllInvoices(customerId);
    }

    @GetMapping("/get-invoice-detail/{invoiceId}")
    public List<InvoiceDetails> getInvoiceDetail(@PathVariable int invoiceId){
        return invoiceService.getInvoiceDetail(invoiceId);
    }

    @PostMapping("/checkout")
    public int checkout(@RequestBody int customerId){
        return invoiceService.checkOut(customerId);
    }

}
