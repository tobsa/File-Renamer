package domain.exceptions;

public abstract class InvalidException extends Exception {

    public InvalidException(String message) {
        super(message);
    }    
}
