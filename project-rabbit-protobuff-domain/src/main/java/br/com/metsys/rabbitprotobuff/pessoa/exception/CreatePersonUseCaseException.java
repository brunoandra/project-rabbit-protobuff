package br.com.metsys.rabbitprotobuff.pessoa.exception;

public class CreatePersonUseCaseException extends UseCaseException {

    private static final long serialVersionUID = -4914517034673349812L;

    public CreatePersonUseCaseException(String message) {
        super(message);
    }

    public CreatePersonUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
