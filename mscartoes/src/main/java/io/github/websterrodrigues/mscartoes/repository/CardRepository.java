package io.github.websterrodrigues.mscartoes.repository;

import io.github.websterrodrigues.mscartoes.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
