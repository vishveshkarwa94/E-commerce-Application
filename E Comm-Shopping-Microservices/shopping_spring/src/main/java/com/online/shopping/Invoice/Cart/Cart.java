package com.online.shopping.Invoice.Cart;

import javax.persistence.*;

@Entity(name = "cart")
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "cust_id")
    private int cust_id;

    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "qty")
    private int qty;

    @Column(name = "price")
    private int price;

    Cart(){}

    public Cart(int cust_id, int prod_id, int qty, int price) {
        this.cust_id = cust_id;
        this.prod_id = prod_id;
        this.qty = qty;
        this.price = price;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
