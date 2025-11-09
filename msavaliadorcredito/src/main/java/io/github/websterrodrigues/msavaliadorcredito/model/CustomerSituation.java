package io.github.websterrodrigues.msavaliadorcredito.model;


import java.util.ArrayList;
import java.util.List;

public class CustomerSituation {

    private CustumerData customerData;
    private List<ClientCard> cards = new ArrayList<>();

    public CustomerSituation() {}

    public CustomerSituation(CustumerData customerData, List<ClientCard> cards) {
        this.customerData = customerData;
        this.cards = cards;
    }

    public CustumerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustumerData customerData) {
        this.customerData = customerData;
    }

    public List<ClientCard> getCards() {
        return cards;
    }

    public void setCards(List<ClientCard> cards) {
        this.cards = cards;
    }

    // Builder manual
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CustumerData customerData;
        private List<ClientCard> cards = new ArrayList<>();

        public Builder customerData(CustumerData customerData) {
            this.customerData = customerData;
            return this;
        }

        public Builder cards(List<ClientCard> cards) {
            this.cards = cards;
            return this;
        }

        public CustomerSituation build() {
            return new CustomerSituation(customerData, cards);
        }
    }
}