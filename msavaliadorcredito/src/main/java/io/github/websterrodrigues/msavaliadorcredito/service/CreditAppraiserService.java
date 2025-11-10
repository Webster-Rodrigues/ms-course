package io.github.websterrodrigues.msavaliadorcredito.service;

import io.github.websterrodrigues.msavaliadorcredito.model.ClientCard;
import io.github.websterrodrigues.msavaliadorcredito.resource.CardResourceClient;
import io.github.websterrodrigues.msavaliadorcredito.resource.ClientResourceClient;
import io.github.websterrodrigues.msavaliadorcredito.model.CustomerSituation;
import io.github.websterrodrigues.msavaliadorcredito.model.CustumerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CreditAppraiserService {

    @Autowired
    private ClientResourceClient clientResourceClient;

    @Autowired
    private CardResourceClient cardResourceClient;

    public CustomerSituation getCustomerSituation(String cpf) {
        //obter dados do cliente - msclientes
        ResponseEntity<CustumerData> custumerDataResponse = clientResourceClient.getByCpf(cpf);
        //obter cartoes do cliente - mscartoes
        ResponseEntity<List<ClientCard>> cardResponse = cardResourceClient.getCardsByClient(cpf);

        return CustomerSituation.builder()
                .customerData(custumerDataResponse.getBody())
                .cards(cardResponse.getBody())
                .build();



    }
}
