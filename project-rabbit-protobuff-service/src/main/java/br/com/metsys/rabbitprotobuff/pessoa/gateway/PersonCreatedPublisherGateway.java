package br.com.metsys.rabbitprotobuff.pessoa.gateway;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;

public interface PersonCreatedPublisherGateway {
    void publish(PersonDomain personDomain) throws GatewayException;
}
