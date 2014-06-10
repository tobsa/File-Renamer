package gui;

import domain.Item;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ListItemCellRenderer implements ListCellRenderer {
    public static final int ITEM_NORMAL = 0;
    public static final int ITEM_SAVE = 1;
    
    private int type;
    
    public ListItemCellRenderer(int type) {
        this.type = type;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {  
        return type == ITEM_NORMAL ? handleNormal(value, isSelected) : handleSave(value);
    }
    
    private JLabel handleNormal(Object value, boolean isSelected) {
        Item item = (Item)value;
        
        JLabel label = new JLabel(item.getName() + (item.hasChanges() ? " *" : ""));
        if(isSelected) {
            label.setOpaque(true);
            label.setBackground(new Color(51, 153, 255));
        }
        else if(item.hasChanges()) {
            label.setOpaque(true);
            label.setBackground(Color.ORANGE);
        }
        
        label.setBorder(new EmptyBorder(1, 1, 1, 0));
        return label;
    }
    
    private JPanel handleSave(Object value) {
        Item item = (Item)value;
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(item.getName());
        label.setBorder(new EmptyBorder(2, 20, 2, 0));
        panel.add(label);
        panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder(item.getOriginalName())));
        
        return panel;
    }
}
