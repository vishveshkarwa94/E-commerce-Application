package com.online.shopping.Invoice;

import javax.persistence.*;

@Entity(name = "invoice_details")
@Table(name = "invoice_details")
public class InvoiceDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "invoice_id")
    private int invoice_id;

    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "qty")
    private int qty;

    @Column(name = "total")
    private int total;

    InvoiceDetails(){}

    public InvoiceDetails(int invoice_id, int prod_id, int qty, int total) {
        this.invoice_id = invoice_id;
        this.prod_id = prod_id;
        this.qty = qty;
        this.total = total;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
