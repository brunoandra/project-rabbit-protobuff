package br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface PersonCreatedSink {
    String INPUT = "person-created-input";

    @Input(INPUT)
    MessageChannel input();
}
