package io.github.websterrodrigues.msavaliadorcredito.resource;

import io.github.websterrodrigues.msavaliadorcredito.model.CustumerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclientes", path = "/clients")
public interface ClientResourceClient {

    @GetMapping
    ResponseEntity<CustumerData> getByCpf(@RequestParam String cpf);
}
