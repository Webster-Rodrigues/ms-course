package io.github.websterrodrigues.mscartoes.dto;

import io.github.websterrodrigues.mscartoes.domain.Card;
import io.github.websterrodrigues.mscartoes.domain.enuns.CardNetwork;

import java.math.BigDecimal;

public class CardDTO {

    private String name;
    private CardNetwork cardNetwork;
    private BigDecimal income;
    private BigDecimal creditLimit;

    public Card toModel(){
        return new Card(name, cardNetwork, income, creditLimit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardNetwork getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(CardNetwork cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
