package domain;

import domain.exceptions.InvalidException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Objects;

public abstract class Rule implements Serializable {
    private String name;
    private LinkedHashMap<String, String> attributes = new LinkedHashMap();
        
    public Rule(String name, String type) {
        this.name = name;
        setAttribute("Type", type);
    }
        
    public String getName() {
        return name;
    }
    
    public final void setAttribute(String key, String value) {
        attributes.put(key, value);
    }
        
    public String getValue(String key) {
        return attributes.get(key);
    }
    
    public LinkedHashMap<String, String> getAttributes() {
        return attributes;
    }
    
    public abstract String applyRule(String text) throws InvalidException;
        
    @Override
    public boolean equals(Object object) {
        if(object == null)
            return false;
        if(object == this)
            return true;
        if(!(object instanceof Rule))
            return false;
        
        Rule rule = (Rule)object;
        return name.equals(rule.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
