package br.com.metsys.rabbitprotobuff.pessoa.exception;

public class UseCaseException extends Exception {
    public UseCaseException(String message) {
        super(message);
    }

    public UseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
