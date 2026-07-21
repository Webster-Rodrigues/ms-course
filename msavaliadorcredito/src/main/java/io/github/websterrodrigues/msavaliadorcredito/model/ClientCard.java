package io.github.websterrodrigues.msavaliadorcredito.model;

import java.math.BigDecimal;

public class ClientCard {

    private String name;
    private String cardNetwork;
    private BigDecimal limitReleased;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(String cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public BigDecimal getLimitReleased() {
        return limitReleased;
    }

    public void setLimitReleased(BigDecimal limitReleased) {
        this.limitReleased = limitReleased;
    }
}
