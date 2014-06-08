package domain.exceptions;

public class EmptyFieldException extends InvalidException {

    public EmptyFieldException(String name) {
        super("Empty field error! You must enter a " + name + "!");
    }
    
}
