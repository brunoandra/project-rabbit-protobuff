package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception;

public class DeleteGatewayException extends GatewayException {

    private static final long serialVersionUID = -7801373725414286778L;

    public DeleteGatewayException(String message) {
        super(message);
    }

    public DeleteGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
