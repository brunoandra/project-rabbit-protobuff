package br.com.metsys.rabbitprotobuff.pessoa.listener;

import br.com.metsys.rabbitprotobuff.pessoa.exception.UseCaseException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.PersonMessage;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.sink.PersonCreatedProtobufSink;
import br.com.metsys.rabbitprotobuff.pessoa.usecase.CreatePersonUseCase;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
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
    public void execute(byte[] personDomain, @Headers Map<String, String> headers) throws UseCaseException, InvalidProtocolBufferException {
        PersonMessage.personMessage personMessage = PersonMessage.personMessage.parseFrom(personDomain);
        //createPersonUseCase.execute(personDomain);
        System.out.print(personMessage.toByteString());
        System.out.print("\n");
    }

}
