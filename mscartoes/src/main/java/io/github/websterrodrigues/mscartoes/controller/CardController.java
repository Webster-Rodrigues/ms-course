package io.github.websterrodrigues.mscartoes.controller;

import io.github.websterrodrigues.mscartoes.domain.Card;
import io.github.websterrodrigues.mscartoes.dto.CardDTO;
import io.github.websterrodrigues.mscartoes.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping("/status")
    public String status(){
        return "MS-Cartoes OK";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CardDTO cardDTO){
        Card card = cardDTO.toModel();
        service.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public ResponseEntity getCardsLimitLessEqual(@RequestParam Long income){
        List<Card> list = service.getCardsLimitLessEqual(income);
        return ResponseEntity.ok(list);
    }
}
