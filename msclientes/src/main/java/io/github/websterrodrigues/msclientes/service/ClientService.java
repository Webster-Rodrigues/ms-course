package io.github.websterrodrigues.msclientes.service;

import io.github.websterrodrigues.msclientes.domain.Client;
import io.github.websterrodrigues.msclientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    public ClientRepository repository;

    public Client save(Client client){
        return repository.save(client);
    }

    public Optional<Client> getByCPF(String cpf){
        return repository.findByCpf(cpf);
    }
}
