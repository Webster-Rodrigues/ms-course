package io.github.websterrodrigues.msavaliadorcredito.model;

import java.util.ArrayList;
import java.util.List;

public class ReturnCustomerReview {

    private List<ApprovedCards> approvedCards = new ArrayList<>();

    public List<ApprovedCards> getApprovedCards() {
        return approvedCards;
    }

    public void setApprovedCards(List<ApprovedCards> approvedCards) {
        this.approvedCards = approvedCards;
    }
}
