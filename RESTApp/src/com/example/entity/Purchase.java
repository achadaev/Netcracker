package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @Column(name = "order_number")
    private int orderNumber;
    private Date date;
    private int seller;
    private int customer;
    private int book;
    private int quantity;
    private double amount;

    public Purchase(int orderNumber, Date date, int seller, int customer, int book, int quantity, double amount) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.seller = seller;
        this.customer = customer;
        this.book = book;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Purchase() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "orderNumber=" + orderNumber +
                ", date=" + date +
                ", seller=" + seller +
                ", customer=" + customer +
                ", book=" + book +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
