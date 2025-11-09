package io.github.websterrodrigues.msavaliadorcredito.service;

import io.github.websterrodrigues.msavaliadorcredito.resource.ClientResourceClient;
import io.github.websterrodrigues.msavaliadorcredito.model.CustomerSituation;
import io.github.websterrodrigues.msavaliadorcredito.model.CustumerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditAppraiserService {

    @Autowired
    private ClientResourceClient clientResourceClient;

    public CustomerSituation getCustomerSituation(String cpf) {
        //obter dados do cliente - msclientes
        ResponseEntity<CustumerData> custumerDataResponse = clientResourceClient.getByCpf(cpf);

        return CustomerSituation.builder()
                .customerData(custumerDataResponse.getBody())
                .build();


        //obter cartoes do cliente - mscartoes
    }
}
