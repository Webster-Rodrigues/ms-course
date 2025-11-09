package io.github.websterrodrigues.mscartoes.service;

import io.github.websterrodrigues.mscartoes.domain.ClientCard;
import io.github.websterrodrigues.mscartoes.repository.ClientCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardService {

    @Autowired
    private ClientCardRepository repository;

    public List<ClientCard> listCardByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
