package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception;

public class FindGatewayException extends GatewayException {

    private static final long serialVersionUID = 7655997857402379894L;

    public FindGatewayException(String message) {
        super(message);
    }

    public FindGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
