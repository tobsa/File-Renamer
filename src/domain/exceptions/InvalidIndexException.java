package domain.exceptions;

public class InvalidIndexException extends InvalidException {
    
    public InvalidIndexException(String name, String text) {
        super("Invalid index error! Can't apply rule \"" + name +"\" on \"" + text + "\"");
    }
}
