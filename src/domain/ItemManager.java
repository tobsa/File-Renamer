package domain;

import domain.exceptions.FileExistException;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ItemManager {
    private Set<Item> items = new LinkedHashSet();
    private List<IIMListener> listeners = new ArrayList();
    
    public void addItems(File[] files) {
        items.addAll(toListItems(files));     
        notifyListeners();
    }
        
    public Set<Item> getItems() {
        return items;
    }
    
    public void registerListener(IIMListener listener) {
        listeners.add(listener);
    }
    
    public void removeItems(List<Item> items) {
        this.items.removeAll(items);
        notifyListeners();
    }
    
    public void removeAll() {
        items.clear();
        notifyListeners();
    }
    
    public List<Item> getItemsWithChanges() {
        List<Item> itemsList = new ArrayList();
        
        for(Item item : items)
            if(item.hasChanges())
                itemsList.add(item);
        
        return itemsList;
    }
        
    private ArrayList<Item> toListItems(File[] files) {
        ArrayList<Item> list = new ArrayList();
        
        for(File file : files)
            list.add(new Item(file));
        
        return list;
    }
    
    public void notifyListeners() {
        for(IIMListener listener : listeners) 
            listener.itemChanged();
    }
    
    public boolean hasChanges() {
        for(Item item : items)
            if(item.hasChanges())
                return true;
        
        return false;
    }
    
    public List<String> save(String path){
        List<String> messages = new ArrayList();
        
        for(Item item : items) {
            try {
                item.save(path);
            } catch (FileExistException ex) {
                messages.add(ex.getMessage());
            }
        }
        
        return messages;
    }
}
