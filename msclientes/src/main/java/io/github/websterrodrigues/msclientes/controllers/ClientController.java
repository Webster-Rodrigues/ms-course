package io.github.websterrodrigues.msclientes.controllers;

import io.github.websterrodrigues.msclientes.domain.Client;
import io.github.websterrodrigues.msclientes.dto.ClientDTO;
import io.github.websterrodrigues.msclientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientService service;

    @Autowired
    private static Logger logger = Logger.getLogger(ClientController.class.getName());

//    @GetMapping
//    public String status(){
//        logger.info("Obtendo o status do msclientes");
//        return "ok";
//    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientDTO client){
        Client savedClient = service.save(client.toModel());
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping
    public ResponseEntity getByCpf(@RequestParam String cpf){
        Optional<Client> client = service.getByCPF(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

}
