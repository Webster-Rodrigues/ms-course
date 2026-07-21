package io.github.websterrodrigues.mscartoes.infra.rbmqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.websterrodrigues.mscartoes.domain.Card;
import io.github.websterrodrigues.mscartoes.domain.CardRequestData;
import io.github.websterrodrigues.mscartoes.domain.ClientCard;
import io.github.websterrodrigues.mscartoes.repository.CardRepository;
import io.github.websterrodrigues.mscartoes.repository.ClientCardRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuanceSubscriber {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ClientCardRepository clientCardRepository;

    //Direciona qual fila escutar
    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void ReceiveRequestIssuance(@Payload String payload){
        try {
        ObjectMapper mapper = new  ObjectMapper();
        CardRequestData dados = mapper.readValue(payload, CardRequestData.class);
        Card card = cardRepository.findById(dados.getIdCard()).orElseThrow();

        ClientCard clientCard = new ClientCard(dados.getCpf(), card, dados.getLimitReleased());
        clientCardRepository.save(clientCard);


        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }
    }

}
