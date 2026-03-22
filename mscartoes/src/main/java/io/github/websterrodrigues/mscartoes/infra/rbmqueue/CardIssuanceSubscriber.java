package io.github.websterrodrigues.mscartoes.infra.rbmqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuanceSubscriber {

    //Direciona qual fila escutar
    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void ReceiveRequestIssuance(@Payload String payload){
        System.out.println(payload);
    }

}
