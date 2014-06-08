package domain.rules;

import domain.Rule;

public class RuleRegex extends Rule {
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
    public String applyRule(String text) {
        return text.replaceAll(regex, replacement).replaceAll("\\?", " ");
    }
}
