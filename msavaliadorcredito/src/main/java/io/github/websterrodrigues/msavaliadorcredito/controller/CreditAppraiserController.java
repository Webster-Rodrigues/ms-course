package io.github.websterrodrigues.msavaliadorcredito.controller;

import io.github.websterrodrigues.msavaliadorcredito.model.CustomerSituation;
import io.github.websterrodrigues.msavaliadorcredito.service.CreditAppraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-appraiser")
public class CreditAppraiserController {

    @Autowired
    private CreditAppraiserService creditAppraiser;

    @GetMapping
    public String status(){
        return "MS-Avaliador-Credito OK";
    }

    @GetMapping( value = "custumer-situation", params = "cpf")
    public ResponseEntity<CustomerSituation> getCustomerSituation(@RequestParam String cpf){
        CustomerSituation situation = creditAppraiser.getCustomerSituation(cpf);
        return ResponseEntity.ok(situation);
    }


}
