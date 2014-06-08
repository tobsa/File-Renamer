package domain;

import java.util.ArrayList;
import java.util.List;

public class EditSession {
    private List<Item> items = new ArrayList();
    
    public void remember(Item item) {
        items.add(item);
    }
    
    public void removeItems(List<Item> items) {
        this.items.removeAll(items);
    }
    
    public List<Item> getItems() {
        return items;
    }
}
