package domain.rules;

import domain.Rule;
import domain.exceptions.InvalidException;
import java.io.Serializable;

public class RuleSubstringIndexOf extends Rule implements Serializable {
    public static final String TYPE = "SubstringIndexOf";
    
    private String index;
    private boolean includeIndex;
    
    public RuleSubstringIndexOf(String name) {
        super(name, TYPE);
    }
    
    public RuleSubstringIndexOf(String name, String index, boolean includeIndex) {
        super(name, TYPE);
        setAttribute("Index of", "" + index);
        setAttribute("Include index", "" + includeIndex);
        this.index = index;
        this.includeIndex = includeIndex;
    }
    
    @Override
    public String applyRule(String text) throws InvalidException {
        int indexOf = text.indexOf(index);
        if(indexOf == -1)
            return text;
        else 
            return text.substring(indexOf + (includeIndex ? 1 : 0));
    }
}
