package domain.rules;

import domain.Rule;
import domain.exceptions.InvalidException;
import domain.exceptions.InvalidRegexException;
import java.io.Serializable;
import java.util.regex.PatternSyntaxException;

public class RuleRegex extends Rule implements Serializable {
    public static final String TYPE = "Regex";
    
    private String regex;
    private String replacement;
    
    public RuleRegex(String name) {
        super(name, TYPE);
    }
    
    public RuleRegex(String name, String regex, String replacement) {
        super(name, TYPE);
        
        setAttribute("Regex", regex);
        setAttribute("Replacement", replacement);
        this.regex = regex;
        this.replacement = replacement;
    } 
        
    @Override
    public String applyRule(String text) throws InvalidException {
        try {
            return text.replaceAll(regex, replacement);
        } catch(PatternSyntaxException ex) {
            throw new InvalidRegexException(ex.getMessage());
        }
    }
}
