package br.com.metsys.rabbitprotobuff.pessoa.exception;

public class FindPersonUseCaseException extends UseCaseException {

    private static final long serialVersionUID = -4914517034673349812L;

    public FindPersonUseCaseException(String message) {
        super(message);
    }

    public FindPersonUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
