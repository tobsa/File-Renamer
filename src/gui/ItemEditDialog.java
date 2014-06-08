package gui;

import domain.EditHistory;
import domain.EditSession;
import domain.Item;
import java.awt.Frame;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

public class ItemEditDialog extends JDialog {
    private List<Item> items;
    private EditHistory editHistory;
    
    public ItemEditDialog(Frame parent, List<Item> items, EditHistory editHistory) {
        super(parent, true);
        initComponents();
                
        this.items = items;
        this.editHistory = editHistory;
                
        updateList();
        
        setLocationRelativeTo(parent);
        setTitle("Edit Item");
        setVisible(true);
    }
    
    private void updateList() {
        DefaultListModel<String> model = new DefaultListModel();
        for(Item item : items)
            model.addElement(item.getEditName());
        listItems.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        labelItems = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listItems = new javax.swing.JList<String>();
        labelSelectedItem = new javax.swing.JLabel();
        textfieldSelectedItem = new javax.swing.JTextField();
        buttonUpdate = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Items"));

        labelItems.setText("Items");

        listItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onListItemValueChangedEvent(evt);
            }
        });
        jScrollPane2.setViewportView(listItems);

        labelSelectedItem.setText("Selected Item");

        buttonUpdate.setText("Update");
        buttonUpdate.setEnabled(false);
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelItems)
                            .addComponent(labelSelectedItem))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(textfieldSelectedItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdate)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSelectedItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldSelectedItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onListItemValueChangedEvent(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onListItemValueChangedEvent
        String name = listItems.getSelectedValue();
        buttonUpdate.setEnabled(name != null);
        textfieldSelectedItem.setEnabled(name != null);
        
        textfieldSelectedItem.setText(name != null ? name : "");
    }//GEN-LAST:event_onListItemValueChangedEvent

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        for(Item item : items)
            item.commitEdit();
        
        dispose();
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        String name = listItems.getSelectedValue();
        if(name == null)
            return;
        
        EditSession session = new EditSession();
        for(Item item : items) {
            if(name.equals(item.getEditName())) {
                item.setEditName(textfieldSelectedItem.getText());
                session.remember(item);
            }
        }
        
        editHistory.rembember(session);
        updateList();
    }//GEN-LAST:event_buttonUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelItems;
    private javax.swing.JLabel labelSelectedItem;
    private javax.swing.JList<String> listItems;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textfieldSelectedItem;
    // End of variables declaration//GEN-END:variables
}
