package io.github.websterrodrigues.msclientes.controllers;

import io.github.websterrodrigues.msclientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientService service;

    @GetMapping
    public String status(){
        return "ok";
    }
    
}
