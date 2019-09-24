package br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface PersonCreatedProtobufSink {
    String INPUT = "person-created-protobuf-input";

    @Input(INPUT)
    MessageChannel input();
}
