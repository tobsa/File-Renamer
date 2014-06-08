package domain.exceptions;

public class InvalidSubstringException extends InvalidException {
    
    public InvalidSubstringException(String name, String text) {
        super("Invalid substring error! Can't apply rule \"" + name + "\" on \"" + text + "\"");
    }
}
