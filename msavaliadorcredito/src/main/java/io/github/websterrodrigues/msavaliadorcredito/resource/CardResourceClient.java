package io.github.websterrodrigues.msavaliadorcredito.resource;

import io.github.websterrodrigues.msavaliadorcredito.model.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscartoes", path = "/cards")
public interface CardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> getCardsByClient(@RequestParam String cpf);
}
