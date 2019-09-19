package br.com.metsys.rabbitprotobuff.pessoa.gateway;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;
import br.com.metsys.rabbitprotobuff.pessoa.model.PersonDomain;

import java.util.Optional;

public interface FindPersonGateway {
    public Optional<PersonDomain> execute(long id) throws GatewayException;
}
