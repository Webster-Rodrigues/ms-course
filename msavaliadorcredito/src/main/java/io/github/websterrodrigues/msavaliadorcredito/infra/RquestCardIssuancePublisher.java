package io.github.websterrodrigues.msavaliadorcredito.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.websterrodrigues.msavaliadorcredito.model.CardRequestData;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RquestCardIssuancePublisher {

    private final RabbitTemplate rabbitTemplate;
    private Queue cardIssuanceQueue;

    public RquestCardIssuancePublisher(RabbitTemplate rabbitTemplate, Queue cardIssuanceQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.cardIssuanceQueue = cardIssuanceQueue;
    }

    public void requestCard(CardRequestData cardRequestData) throws JsonProcessingException {
        String json = convertIntoJson(cardRequestData);
        rabbitTemplate.convertAndSend(cardIssuanceQueue.getName(), json);
    }

    private String convertIntoJson(CardRequestData data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(data);
        return json;
    }
}
