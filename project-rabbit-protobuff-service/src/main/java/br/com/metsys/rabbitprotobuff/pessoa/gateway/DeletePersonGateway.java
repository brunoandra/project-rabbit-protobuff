package br.com.metsys.rabbitprotobuff.pessoa.gateway;

import br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception.GatewayException;

public interface DeletePersonGateway {
    public void execute(long id) throws GatewayException;
}
