package br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonCreatedProtobuffSource {
    String OUTPUT = "person-created-protobuff-output";

    @Output(OUTPUT)
    MessageChannel output();
}
