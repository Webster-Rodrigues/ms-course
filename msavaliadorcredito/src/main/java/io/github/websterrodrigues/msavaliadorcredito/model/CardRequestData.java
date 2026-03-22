package io.github.websterrodrigues.msavaliadorcredito.model;

import java.math.BigDecimal;

public class CardRequestData {

    private Long idCard;
    private String cpf;
    private String address;
    private BigDecimal limitReleased;

    public CardRequestData(){

    }

    public CardRequestData(Long idCard, String cpf, String address, BigDecimal limitReleased) {
        this.idCard = idCard;
        this.cpf = cpf;
        this.address = address;
        this.limitReleased = limitReleased;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
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
