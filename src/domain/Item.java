package domain;

import domain.exceptions.FileExistException;
import domain.exceptions.InvalidException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Item {
    private File file;
    private String name;
    private String path;    
    private Stack<String> undos = new Stack();
    private Stack<String> redos = new Stack();
    private boolean hasChanges = false;
    
    public Item(File file) {
        this.file = file;
        this.name = file.getName();
    }
    
    public Item(String name) {
        this.name = name;
    }
                
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        undos.push(this.name);
        this.name = name;
        
        hasChanges = true;
    }
    
    public String getOriginalName() {
        return file.getName();
    }
                
    public void applyRules(List<Rule> rules) throws InvalidException {        
        undos.push(name);
        for(Rule rule : rules)
            name = rule.applyRule(name);
        
        hasChanges = true;
    }
    
    public void undo() {
        if(!undos.empty()) {
            redos.push(name);
            name = undos.pop();
            hasChanges = true;
        }
    }
    
    public void redo() {
        if(!redos.empty()) {
            undos.push(name);
            name = redos.pop();
            hasChanges = true;
        } 
    }
    
    public void clearUndos() {
        undos.clear();
    }
    
    public void clearRedos() {
        redos.clear();
    }
    
    public boolean hasChanges() {
        if(name.equals(file.getName()))
            return false;
        
        return hasChanges;
    }
    
    public boolean exists() {
        return new File(path + "\\" + name).exists();
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void save() throws FileExistException, IOException {                
        if(!hasChanges())
            return;
        
        File copy = new File(path + "\\" + name);
        if(copy.exists())
            throw new FileExistException(copy);
        
        InputStream  reader = new FileInputStream(file);
        OutputStream writer = new FileOutputStream(copy);

        byte[] buffer = new byte[1024];

        int length;
        while((length = reader.read(buffer)) > 0)
            writer.write(buffer, 0, length);

        reader.close();
        writer.close();
        hasChanges = false; 
    }
    
   
    @Override
    public boolean equals(Object object) {        
        if(object == null)
            return false;
        if(object == this)
            return true;
        if(!(object instanceof Item))
            return false;
        
        Item item = (Item)object;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.file);
        return hash;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
