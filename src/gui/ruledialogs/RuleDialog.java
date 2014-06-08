package gui.ruledialogs;

import domain.Rule;
import domain.exceptions.EmptyFieldException;
import domain.exceptions.InvalidException;
import java.awt.Frame;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JTextField;

public abstract class RuleDialog extends JDialog {
    private Map<String, JTextField> inputFields = new LinkedHashMap();
    
    public RuleDialog(Frame parent) {
        super(parent, true);
    }
    
    public RuleDialog(Frame parent, Map<String, JTextField> inputFields) {
        super(parent, true);
        this.inputFields = inputFields;
    }
        
    public abstract Rule getRule();
    public abstract void reset();
    
    public void registerInputField(String name, JTextField field) {
        inputFields.put(name, field);
    }
    
    public final void validateInputFields() throws InvalidException {
        for(String name : inputFields.keySet()) {
            String text = inputFields.get(name).getText();
            if(text == null || text.isEmpty())
                throw new EmptyFieldException(name);
        }
    }        
}
