package br.com.metsys.rabbitprotobuff.pessoa.listener;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.PersonMessage;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.sink.PersonCreatedProtobufSink;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import br.com.metsys.rabbitprotobuff.pessoa.usecase.CreatePersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Map;

@EnableBinding({PersonCreatedProtobufSink.class})
public class ReceiveCreatePersonProtobuff {

    private final CreatePersonUseCase createPersonUseCase;

    @Autowired
    public ReceiveCreatePersonProtobuff(CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    @StreamListener(target = PersonCreatedProtobufSink.INPUT)
    public void execute(byte[] personDomainByte, @Headers Map<?, ?> headers, @Header(name = "x-death", required = false) Map<?, ?> death) throws Exception {
        PersonMessage.personMessage personMessage = PersonMessage.personMessage.parseFrom(personDomainByte);
        PersonDomain personDomain = PersonDomain.builder().nome(personMessage.getNome())
                .email(personMessage.getEmail())
                .build();
        createPersonUseCase.execute(personDomain);
    }

}
