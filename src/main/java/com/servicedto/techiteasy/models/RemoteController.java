package com.servicedto.techiteasy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "remoteControllers")
public class RemoteController {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String compatibleWith;
    @Column(nullable = false)
    private String batteryType;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int originalStock;

    @OneToOne(mappedBy = "remoteController")
    private Television television;

    public Long getId() {
        return id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

}
