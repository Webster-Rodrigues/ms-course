package io.github.websterrodrigues.msclientes.repository;

import io.github.websterrodrigues.msclientes.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByCpf(String cpf);
}
