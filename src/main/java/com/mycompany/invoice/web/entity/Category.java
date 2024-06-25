package com.mycompany.invoice.web.entity;

import jakarta.persistence.*;

@Entity
public class Category {

    /**
     * ATTRIBUTS
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String name;

    /**
     * CONSTRUCTEUR
     */
    public Category(String name) {
        this.name = name;
    }

    public Category() {
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
}
