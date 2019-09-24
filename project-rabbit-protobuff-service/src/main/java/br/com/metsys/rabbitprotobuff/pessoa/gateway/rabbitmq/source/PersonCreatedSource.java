package br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonCreatedSource {
    String OUTPUT = "person-created-output";

    @Output(OUTPUT)
    MessageChannel output();
}
