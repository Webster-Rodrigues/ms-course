package io.github.websterrodrigues.mscartoes.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "client_card")
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    private BigDecimal creditLimit;

    public ClientCard(){

    }

    public ClientCard(String cpf, Card card, BigDecimal creditLimit) {
        this.cpf = cpf;
        this.card = card;
        this.creditLimit = creditLimit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClientCard that = (ClientCard) o;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", card=" + card +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
