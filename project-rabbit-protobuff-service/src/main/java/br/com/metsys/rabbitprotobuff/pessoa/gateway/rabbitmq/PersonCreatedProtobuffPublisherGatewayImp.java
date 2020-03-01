package br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.PersonCreatedPublisherGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.PersonMessage;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.source.PersonCreatedProtobuffSource;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding({PersonCreatedProtobuffSource.class})
@Service
public class PersonCreatedProtobuffPublisherGatewayImp implements PersonCreatedPublisherGateway {
    private final PersonCreatedProtobuffSource personCreatedSource;

    @Autowired
    public PersonCreatedProtobuffPublisherGatewayImp(PersonCreatedProtobuffSource personCreatedSource) {
        this.personCreatedSource = personCreatedSource;
    }

    @Override
    public void publish(PersonDomain personDomain) throws GatewayException {
        PersonMessage.personMessage personMessage =
                PersonMessage.personMessage.newBuilder()
                        .setNome(personDomain.getNome())
                        .setEmail(personDomain.getEmail() + "proto").build();

        personCreatedSource.output().send(MessageBuilder.withPayload(personMessage.toByteArray()).build());
    }
}
