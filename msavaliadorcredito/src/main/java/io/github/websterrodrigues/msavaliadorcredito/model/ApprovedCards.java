package io.github.websterrodrigues.msavaliadorcredito.model;

import java.math.BigDecimal;

public class ApprovedCards {

    private String name;
    private String cardNetwork;
    private BigDecimal approvedLimit;

    public ApprovedCards() {
    }

    public ApprovedCards(String name, String cardNetwork, BigDecimal approvedLimit) {
        this.name = name;
        this.cardNetwork = cardNetwork;
        this.approvedLimit = approvedLimit;
    }

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

    public BigDecimal getApprovedLimit() {
        return approvedLimit;
    }

    public void setApprovedLimit(BigDecimal approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}
