package io.github.websterrodrigues.msavaliadorcredito.service;

import feign.FeignException;
import io.github.websterrodrigues.msavaliadorcredito.model.*;
import io.github.websterrodrigues.msavaliadorcredito.resource.CardResourceClient;
import io.github.websterrodrigues.msavaliadorcredito.resource.ClientResourceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditAppraiserService {

    @Autowired
    private ClientResourceClient clientResourceClient;

    @Autowired
    private CardResourceClient cardResourceClient;

    public CustomerSituation getCustomerSituation(String cpf) {

        try {
            //obter dados do cliente - msclientes
            ResponseEntity<CustumerData> custumerDataResponse = clientResourceClient.getByCpf(cpf);
            //obter cartoes do cliente - mscartoes
            ResponseEntity<List<ClientCard>> cardResponse = cardResourceClient.getCardsByClient(cpf);

            return CustomerSituation.builder()
                    .customerData(custumerDataResponse.getBody())
                    .cards(cardResponse.getBody())
                    .build();

        } catch (FeignException e) {
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status){
                throw new IllegalArgumentException("Cliente nao encontrado para o CPF informado");
            }
            throw new IllegalArgumentException("Erro ao obter dados do cliente");
        }

    }

    public ReturnCustomerReview performCustomerReview(String cpf, Long income) {
        try {
            ResponseEntity<CustumerData> custumerDataResponse = clientResourceClient.getByCpf(cpf);
            ResponseEntity<List<Card>> cardResponse = cardResourceClient.getCardsLimitLessEqual(income);

            List<Card> cards = cardResponse.getBody();
            List<ApprovedCards> listApprovedCards = cards.stream().map(card -> {

                CustumerData custumerData = custumerDataResponse.getBody();

                BigDecimal basicLimit = card.getCreditLimit();
                BigDecimal ageBD = BigDecimal.valueOf(custumerData.getAge());

                BigDecimal factor = ageBD.divide(BigDecimal.valueOf(10));
                BigDecimal approvedLimit = factor.multiply(basicLimit);

                ApprovedCards approvedCards = new ApprovedCards();
                approvedCards.setName(card.getName());
                approvedCards.setCardNetwork(card.getCardNetwork());
                approvedCards.setApprovedLimit(approvedLimit);

                return approvedCards;

            } ).collect(Collectors.toList());

            ReturnCustomerReview returnCustomerReview = new ReturnCustomerReview();
            returnCustomerReview.setApprovedCards(listApprovedCards);

            return returnCustomerReview;

        }catch (FeignException e) {
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status){
                throw new IllegalArgumentException("Cliente nao encontrado para o CPF informado");
            }
            throw new IllegalArgumentException("Erro ao obter dados do cliente");
        }

    }
}
