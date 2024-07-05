package com.servicedto.techiteasy.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "wallBrackets")
public class WallBracket {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String size;
    @Column
    private boolean adjustable;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "wallBrackets")
    private Set<Television> televisions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
