package br.com.metsys.rabbitprotobuff.pessoa.exception;

public class DeletePersonUseCaseException extends UseCaseException {

    private static final long serialVersionUID = -4914517034673349812L;

    public DeletePersonUseCaseException(String message) {
        super(message);
    }

    public DeletePersonUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
