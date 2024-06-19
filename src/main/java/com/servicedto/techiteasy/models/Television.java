package com.servicedto.techiteasy.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private double availableSize;
    @Column(nullable = false)
    private double refreshRate;
    @Column(nullable = false)
    private String screenType;
    @Column(nullable = false)
    private String screenQuality;
    @Column
    private boolean smartTv;
    @Column
    private boolean wifi;
    @Column
    private boolean voiceControl;
    @Column
    private boolean hdr;
    @Column
    private boolean bluetooth;
    @Column
    private boolean ambiLight;
    @Column(nullable = false)
    private Integer originalStock;
    @Column(nullable = false)
    private Integer sold;

    @OneToOne
    private RemoteController remoteController;

    @OneToMany(mappedBy = "television")
    private Set<CIModule> ciModules = new HashSet<>();

    @ManyToMany
    private Set<WallBracket> wallBrackets = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(double availableSize) {
        this.availableSize = availableSize;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public boolean isHdr() {
        return hdr;
    }

    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public Set<CIModule> getCiModules() {
        return ciModules;
    }

    public Set<WallBracket> getWallBrackets() {
        return wallBrackets;
    }

    public void setWallBrackets(Set<WallBracket> wallBrackets) {
        this.wallBrackets = wallBrackets;
    }
}
