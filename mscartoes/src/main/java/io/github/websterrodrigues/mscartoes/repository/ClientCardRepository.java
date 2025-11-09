package io.github.websterrodrigues.mscartoes.repository;


import io.github.websterrodrigues.mscartoes.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientCardRepository extends JpaRepository<ClientCard, UUID> {
    List<ClientCard> findByCpf(String cpf);
}
