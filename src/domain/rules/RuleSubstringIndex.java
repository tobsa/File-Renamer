package domain.rules;

import domain.Rule;
import domain.exceptions.InvalidSubstringException;
import domain.exceptions.InvalidException;
import domain.exceptions.InvalidIndexException;
import java.io.Serializable;

public class RuleSubstringIndex extends Rule implements Serializable {
    public static final String TYPE = "SubstringIndex";
    
    private int index;
    
    public RuleSubstringIndex(String name) {
        super(name, TYPE);
    }
    
    public RuleSubstringIndex(String name, int index) {
        super(name, TYPE);
        setAttribute("Index", "" + index);
        this.index = index;
    }
    
    @Override
    public String applyRule(String text) throws InvalidException {
        if(index < 0 || index >= text.length())
            throw new InvalidIndexException(getName(), text);

        String substring = text.substring(index);
        if(substring.isEmpty())
            throw new InvalidSubstringException(getName(), text);

        return substring;
    }
    
}
