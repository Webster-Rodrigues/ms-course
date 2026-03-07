package io.github.websterrodrigues.mscartoes.controller;

import io.github.websterrodrigues.mscartoes.domain.Card;
import io.github.websterrodrigues.mscartoes.domain.ClientCard;
import io.github.websterrodrigues.mscartoes.dto.CardDTO;
import io.github.websterrodrigues.mscartoes.dto.ClientCardDTO;
import io.github.websterrodrigues.mscartoes.service.CardService;
import io.github.websterrodrigues.mscartoes.service.ClientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ClientCardService clientCardService;

    @GetMapping("/status")
    public String status(){
        return "MS-Cartoes OK";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CardDTO cardDTO){
        Card card = cardDTO.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsLimitLessEqual(@RequestParam Long income){
        List<Card> list = cardService.getCardsLimitLessEqual(income);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardDTO>> getCardsByClient(@RequestParam String cpf){
        List<ClientCard> list = clientCardService.listCardByCpf(cpf);
        List<ClientCardDTO> resultList = list.stream()
                .map(ClientCardDTO::fromModel)
                .toList();
        return ResponseEntity.ok(resultList);

    }
}
