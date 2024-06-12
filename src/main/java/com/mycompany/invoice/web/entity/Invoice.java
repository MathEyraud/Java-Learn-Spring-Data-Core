package com.mycompany.invoice.web.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("invoice")
public class Invoice {

    /**
     * ATTRIBUTS
     */
    @Id
    @Column("INVOICE_NUMBER")
    private String number;

    @Column("CUSTOMER_NAME")
    private String customerName;

    @Column("ORDER_NUMBER")
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