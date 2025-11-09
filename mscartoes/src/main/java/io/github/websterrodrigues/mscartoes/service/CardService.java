package io.github.websterrodrigues.mscartoes.service;

import io.github.websterrodrigues.mscartoes.domain.Card;
import io.github.websterrodrigues.mscartoes.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public Card save(Card card){
        return repository.save(card);
    }

    public List<Card> getCardsLimitLessEqual(Long income){
        BigDecimal incomeBigDecimal = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
