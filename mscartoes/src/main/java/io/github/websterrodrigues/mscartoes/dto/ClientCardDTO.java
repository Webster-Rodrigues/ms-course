package io.github.websterrodrigues.mscartoes.dto;

import io.github.websterrodrigues.mscartoes.domain.ClientCard;
import io.github.websterrodrigues.mscartoes.domain.enuns.CardNetwork;

import java.math.BigDecimal;

public class ClientCardDTO {

    private String name;
    private String cardNetwork;
    private BigDecimal limitReleased;

    public ClientCardDTO(){

    }

    public ClientCardDTO(String name, String cardNetwork, BigDecimal limitReleased) {
        this.name = name;
        this.cardNetwork = cardNetwork;
        this.limitReleased = limitReleased;
    }

    public static ClientCardDTO fromModel(ClientCard clientCard){
        return new ClientCardDTO(
                clientCard.getCard().getName(),
                clientCard.getCard().getCardNetwork().toString(),
                clientCard.getCreditLimit());
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

    public BigDecimal getLimitReleased() {
        return limitReleased;
    }

    public void setLimitReleased(BigDecimal limitReleased) {
        this.limitReleased = limitReleased;
    }
}
