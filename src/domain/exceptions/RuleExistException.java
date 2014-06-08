package domain.exceptions;

public class RuleExistException extends InvalidException {

    public RuleExistException(String name) {
        super("Rule \"" + name + "\" already exists! Please choose a new name!");
    }
}
