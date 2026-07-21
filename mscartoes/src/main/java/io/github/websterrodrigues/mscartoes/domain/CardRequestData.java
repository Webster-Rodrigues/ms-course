package io.github.websterrodrigues.mscartoes.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class CardRequestData {

    private UUID idCard;
    private String cpf;
    private String address;
    private BigDecimal limitReleased;

    public CardRequestData(){

    }

    public CardRequestData(UUID idCard, String cpf, String address, BigDecimal limitReleased) {
        this.idCard = idCard;
        this.cpf = cpf;
        this.address = address;
        this.limitReleased = limitReleased;
    }

    public UUID getIdCard() {
        return idCard;
    }

    public void setIdCard(UUID idCard) {
        this.idCard = idCard;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLimitReleased() {
        return limitReleased;
    }

    public void setLimitReleased(BigDecimal limitReleased) {
        this.limitReleased = limitReleased;
    }
}
