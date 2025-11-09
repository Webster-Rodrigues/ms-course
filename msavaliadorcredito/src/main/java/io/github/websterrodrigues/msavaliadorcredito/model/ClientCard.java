package io.github.websterrodrigues.msavaliadorcredito.model;

import java.math.BigDecimal;

public class ClientCard {

    private String name;
    private String brand;
    private BigDecimal limitReleased;

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

    public BigDecimal getLimitReleased() {
        return limitReleased;
    }

    public void setLimitReleased(BigDecimal limitReleased) {
        this.limitReleased = limitReleased;
    }
}
