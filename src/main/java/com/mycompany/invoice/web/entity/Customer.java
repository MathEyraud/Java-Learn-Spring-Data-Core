package com.mycompany.invoice.web.entity;

import jakarta.persistence.*;

@Entity
public class Customer {

    /**
     * ATTRIBUTS
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true,optional = false)
    @JoinColumn(name="ID_ADDRESS")
    private Address address;



    /**
     * CONSTRUCTEUR
     */
    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
