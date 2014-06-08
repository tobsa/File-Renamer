package gui;

import domain.Item;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class ListItemCellRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Item item = (Item)value;
                
//        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        panel.setBorder(null);
//                
//        panel.add(new JLabel(item.getName()));
//        if(item.hasChanges())
//            panel.add(new JLabel("*"));
//        
//        if(isSelected)
//            panel.setBackground(new Color(51, 153, 255));
        
                
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
}
