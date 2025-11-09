package io.github.websterrodrigues.msavaliadorcredito.model;


import ch.qos.logback.core.net.server.Client;

import java.util.ArrayList;
import java.util.List;

public class CustomerSituation {

    private CustumerData customerData;
    private List<ClientCard> cards = new ArrayList<>();

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
}
