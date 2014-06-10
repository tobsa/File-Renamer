package gui;

import domain.Rule;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.TitledBorder;

public class ListRuleCellRenderer implements ListCellRenderer {
    
    @Override
    public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {        
        Rule rule = (Rule)object;
        
        JPanel panel = new JPanel(new GridLayout(rule.getAttributes().size(), 0));
        
        for(String key : rule.getAttributes().keySet()) {
            JPanel panelCell = new JPanel(new GridLayout(0, 2));
            panelCell.add(new JLabel(key + ": "));
            panelCell.add(new JLabel("|" + rule.getValue(key).replaceAll(" ", "[SPACE]") + "|"));
            
            if(isSelected)
                panelCell.setBackground(new Color(51, 153, 255));
            
            panel.add(panelCell);
        }
        
        panel.setBorder(new TitledBorder(rule.getName()));
        
        if(isSelected)
            panel.setBackground(new Color(51, 153, 255));
                        
        return panel;
    }
    
}
