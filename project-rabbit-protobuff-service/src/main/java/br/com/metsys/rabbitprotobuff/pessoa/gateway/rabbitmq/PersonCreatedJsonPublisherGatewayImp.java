package br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.PersonCreatedPublisherGateway;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.gateway.rabbitmq.source.PersonCreatedSource;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding({PersonCreatedSource.class})
@Service
public class PersonCreatedJsonPublisherGatewayImp implements PersonCreatedPublisherGateway {
    private final PersonCreatedSource personCreatedSource;
    private ObjectMapper objectMapper;

    @Autowired
    public PersonCreatedJsonPublisherGatewayImp(PersonCreatedSource personCreatedSource, ObjectMapper objectMapper) {
        this.personCreatedSource = personCreatedSource;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(PersonDomain personDomain) throws GatewayException {

        try{
            String orderJson = objectMapper.writeValueAsString(personDomain);
            personCreatedSource.output().send(MessageBuilder.withPayload(orderJson.getBytes()).build());

        }catch (Exception e)
        {
            throw new GatewayException("erro", e);
        }
    }
}
