package domain;

import domain.exceptions.RuleExistException;
import java.util.ArrayList;
import java.util.List;

public class RuleManager {
    private List<Rule> availableRules = new ArrayList();
    private List<Rule> activeRules    = new ArrayList();
    private List<IRMListener> listeners = new ArrayList();
    
    public void registerListener(IRMListener listener) {
        listeners.add(listener);
    }
        
    public void addRule(Rule rule) throws RuleExistException {
        if(availableRules.contains(rule) || activeRules.contains(rule))
            throw new RuleExistException(rule.getName());
            
        availableRules.add(rule);
        notifyListeners();
    }
    
    public void activateRules(List<Rule> rules) {
        availableRules.removeAll(rules);
        activeRules.addAll(rules);
        notifyListeners();
    }
    
    public void activateAll() {
        activeRules.addAll(availableRules);
        availableRules.clear();
        notifyListeners();
    }
    
    public void deactivateRules(List<Rule> rules) {
        activeRules.removeAll(rules);
        availableRules.addAll(rules);
        notifyListeners();
    }
    
    public void deactivateAll() {
        availableRules.addAll(activeRules);
        activeRules.clear();
        notifyListeners();
    }
    
    public void removeRules(List<Rule> rules) {
        availableRules.removeAll(rules);
        notifyListeners();
    }
    
    public List<Rule> getAvailableRules() {
        return availableRules;
    }
    
    public List<Rule> getActiveRules() {
        return activeRules;
    }
    
    public void swapAvailableRules(int index1, int index2) {
        Rule rule = availableRules.get(index1);
        availableRules.set(index1, availableRules.get(index2));
        availableRules.set(index2, rule);
        notifyListeners();
    }
    
    public void swapActiveRules(int index1, int index2) {
        Rule rule = activeRules.get(index1);
        activeRules.set(index1, activeRules.get(index2));
        activeRules.set(index2, rule);
        notifyListeners();
    }
    
    private void notifyListeners() {
        for(IRMListener listener : listeners)
            listener.rulesChanged();
    }
}
