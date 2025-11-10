package io.github.websterrodrigues.msavaliadorcredito.controller;

import io.github.websterrodrigues.msavaliadorcredito.model.CustomerSituation;
import io.github.websterrodrigues.msavaliadorcredito.model.EvaluationData;
import io.github.websterrodrigues.msavaliadorcredito.model.ReturnCustomerReview;
import io.github.websterrodrigues.msavaliadorcredito.service.CreditAppraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        try {
            CustomerSituation situation = creditAppraiser.getCustomerSituation(cpf);
            return ResponseEntity.ok(situation);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping
    public ResponseEntity assessment(@RequestBody EvaluationData dataResquest){
        try {
            ReturnCustomerReview evaluationData = creditAppraiser.performCustomerReview(dataResquest.getCpf(), dataResquest.getIncome());
            return ResponseEntity.ok(evaluationData);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }


}
