package br.com.metsys.rabbitprotobuff.pessoa.gateway;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;

public interface SavePersonGateway {
    public PersonDomain execute (PersonDomain personDomain) throws GatewayException;
}
