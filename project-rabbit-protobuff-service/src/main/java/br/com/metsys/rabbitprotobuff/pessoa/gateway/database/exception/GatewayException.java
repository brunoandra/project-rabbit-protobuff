package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception;

public class GatewayException extends Exception {

    public GatewayException(String message) {
        super(message);
    }

    public GatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
