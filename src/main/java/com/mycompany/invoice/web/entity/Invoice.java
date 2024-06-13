package com.mycompany.invoice.web.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    /**
     * ATTRIBUTS
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVOICE_NUMBER")
    private String number;

    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="ORDER_NUMBER")
    private String orderNumber;

    /**
     * GETTERS/SETTERS
     */
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}