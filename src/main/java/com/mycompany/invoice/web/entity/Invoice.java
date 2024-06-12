package com.mycompany.invoice.web.entity;

public class Invoice {

    /**
     * ATTRIBUTS
     */
    private String number;
    private String customerName;
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