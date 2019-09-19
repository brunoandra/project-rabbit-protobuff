package br.com.metsys.rabbitprotobuff.pessoa.gateway.database.exception;

public class SaveGatewayException extends GatewayException {

    private static final long serialVersionUID = -7826873495155795315L;

    public SaveGatewayException(String message) {
        super(message);
    }

    public SaveGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
