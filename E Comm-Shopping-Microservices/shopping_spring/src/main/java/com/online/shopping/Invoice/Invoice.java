package com.online.shopping.Invoice;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "invoice")
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue
    @Column(name = "invoice_id")
    private int id;

    @Column(name = "cust_id")
    private int cust_id;

    @Column(name = "invoice_date")
    private Date invoice_date;

    @Column(name = "total")
    private int total;

    Invoice(){}

    public Invoice(int cust_id, Date invoice_date, int total) {
        this.cust_id = cust_id;
        this.invoice_date = invoice_date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
