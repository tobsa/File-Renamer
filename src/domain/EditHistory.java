package domain;

import java.util.List;
import java.util.Stack;

public class EditHistory {
    private Stack<EditSession> undoSessions = new Stack();
    private Stack<EditSession> redoSessions = new Stack();
    
    public void rembember(EditSession session) {
        undoSessions.push(session);
    }
    
    public void removeItems(List<Item> items) {
        for(EditSession session : undoSessions)
            session.removeItems(items);
        for(EditSession session : redoSessions)
            session.removeItems(items);  
        
        undoSessions = cleanStack(undoSessions);
        redoSessions = cleanStack(redoSessions);
    }
        
    public EditSession undo() {
        EditSession session = undoSessions.pop();
        redoSessions.push(session);
        return session;
    }
    
    public EditSession redo() {
        EditSession session = redoSessions.pop();
        undoSessions.push(session);
        return session;
    }
    
    public boolean hasUndos() {
        return !undoSessions.empty();
    }
    
    public boolean hasRedos() {
        return !redoSessions.empty();
    }
    
    public void clearUndos() {
        while(!undoSessions.empty()) {
            EditSession session = undoSessions.pop();
            for(Item item : session.getItems())
                item.clearUndos();
        }
            
    }
    
    public void clearRedos() {
        while(!redoSessions.empty()) {
            EditSession session = redoSessions.pop();
            for(Item item : session.getItems())
                item.clearRedos();
        }
    }
    
    private Stack<EditSession> cleanStack(Stack<EditSession> sessions) {
        Stack<EditSession> cleanSessions = new Stack();
        
        while(!sessions.isEmpty()) {
            EditSession session = sessions.pop();
            if(!session.getItems().isEmpty())
                cleanSessions.push(session);
        }
        
        return cleanSessions;
    }
}
