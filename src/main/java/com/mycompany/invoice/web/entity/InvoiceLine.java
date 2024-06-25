package com.mycompany.invoice.web.entity;

import jakarta.persistence.*;

@Entity
public class InvoiceLine {

    /**
     * ATTRIBUTS
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Short quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    /**
     * CONSTRUCTEUR
     */
    public InvoiceLine() {
    }

    public InvoiceLine(Short quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    /**
     * GETTERS/SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
