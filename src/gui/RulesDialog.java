package gui;

import gui.ruledialogs.RuleDialog;
import gui.ruledialogs.RegexDialog;
import domain.Rule;
import domain.RuleManager;
import domain.exceptions.RuleExistException;
import gui.ruledialogs.Substring1IndexDialog;
import gui.ruledialogs.Substring1IndexOfDialog;
import java.awt.Frame;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import domain.IRMListener;
import domain.rules.RuleRegex;
import domain.rules.RuleSubstringIndex;
import domain.rules.RuleSubstringIndexOf;
import java.io.IOException;
import technical.FileManager;

public class RulesDialog extends JDialog implements IRMListener {
    private RuleManager ruleManager;
    private Map<String, RuleDialog> dialogs = new LinkedHashMap();
    
    public RulesDialog(Frame parent, RuleManager ruleManager) {
        super(parent, true);
        initComponents();
                
        this.ruleManager = ruleManager;
                
        listAvailableRules.setCellRenderer(new ListRuleCellRenderer());
        listActiveRules.setCellRenderer(new ListRuleCellRenderer());
        
        updateList(listAvailableRules, ruleManager.getAvailableRules());
        updateList(listActiveRules, ruleManager.getActiveRules());
                                
        dialogs.put(RuleRegex.TYPE, new RegexDialog(parent));
        dialogs.put(RuleSubstringIndex.TYPE, new Substring1IndexDialog(parent));
        dialogs.put(RuleSubstringIndexOf.TYPE, new Substring1IndexOfDialog(parent));
        
        comboRuleTypes.removeAllItems();
        for(String key : dialogs.keySet())
            comboRuleTypes.addItem(key);
        comboRuleTypes.setSelectedIndex(0);
                
        setTitle("Rename Rules");
        setLocationRelativeTo(parent);
    }
    
    private void saveRules() {
        try {
            FileManager.save("avrules.dat", ruleManager.getAvailableRules());
            FileManager.save("acrules.dat", ruleManager.getActiveRules());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(RulesDialog.this, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
           
    @Override
    public void rulesChanged() {
        updateList(listAvailableRules, ruleManager.getAvailableRules());
        updateList(listActiveRules, ruleManager.getActiveRules());
    }
        
    private void updateList(JList<Rule> list, List<Rule> rules) {
        DefaultListModel<Rule> model = new DefaultListModel<>();
        for(Rule rule : rules)
            model.addElement(rule);
        list.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        buttonAddRule = new javax.swing.JButton();
        comboRuleTypes = new javax.swing.JComboBox<String>();
        labelRuleType = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailableRules = new javax.swing.JList<domain.Rule>();
        buttonActivate = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        buttonAvailableMoveUp = new javax.swing.JButton();
        buttonAvailableMoveDown = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listActiveRules = new javax.swing.JList<domain.Rule>();
        buttonDeactivate = new javax.swing.JButton();
        buttonActiveMoveUp = new javax.swing.JButton();
        buttonActiveMoveDown = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Rename Rules"));

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Add Rule"), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        buttonAddRule.setText("Add Rule");
        buttonAddRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddRuleActionPerformed(evt);
            }
        });

        comboRuleTypes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ReplaceAll", "Substring" }));

        labelRuleType.setText("Rule type");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonAddRule, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(labelRuleType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboRuleTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRuleType)
                    .addComponent(comboRuleTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAddRule)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Rules"));

        listAvailableRules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAvailableRulesMouseClicked(evt);
            }
        });
        listAvailableRules.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onListAvailableRulesValueChangedEvent(evt);
            }
        });
        jScrollPane1.setViewportView(listAvailableRules);

        buttonActivate.setText("Activate");
        buttonActivate.setEnabled(false);
        buttonActivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActivateActionPerformed(evt);
            }
        });

        buttonRemove.setText("Remove");
        buttonRemove.setEnabled(false);
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        buttonAvailableMoveUp.setText("Move Up");
        buttonAvailableMoveUp.setEnabled(false);
        buttonAvailableMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAvailableMoveUpActionPerformed(evt);
            }
        });

        buttonAvailableMoveDown.setText("Move Down");
        buttonAvailableMoveDown.setEnabled(false);
        buttonAvailableMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAvailableMoveDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonAvailableMoveDown)
                                .addGap(144, 144, 144))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonAvailableMoveUp, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(buttonActivate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAvailableMoveUp)
                            .addComponent(buttonRemove))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAvailableMoveDown))
                    .addComponent(buttonActivate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Active Rules"));

        listActiveRules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listActiveRulesMouseClicked(evt);
            }
        });
        listActiveRules.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onListActiveRulesValueChangedEvent(evt);
            }
        });
        jScrollPane2.setViewportView(listActiveRules);

        buttonDeactivate.setText("Deactivate");
        buttonDeactivate.setEnabled(false);
        buttonDeactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeactivateActionPerformed(evt);
            }
        });

        buttonActiveMoveUp.setText("Move Up");
        buttonActiveMoveUp.setEnabled(false);
        buttonActiveMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActiveMoveUpActionPerformed(evt);
            }
        });

        buttonActiveMoveDown.setText("Move Down");
        buttonActiveMoveDown.setEnabled(false);
        buttonActiveMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActiveMoveDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(buttonDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonActiveMoveUp, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonActiveMoveDown, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(buttonActiveMoveUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonActiveMoveDown))
                    .addComponent(buttonDeactivate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonAddRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddRuleActionPerformed
        String selectedType = comboRuleTypes.getItemAt(comboRuleTypes.getSelectedIndex());
        if(selectedType == null)
            return;
        
        RuleDialog dialog = dialogs.get(selectedType);
        dialog.setVisible(true);
        
        Rule rule = dialog.getRule();
        if(rule != null) {
            try {
                ruleManager.addRule(rule);
                saveRules();
            } catch (RuleExistException ex) {
                JOptionPane.showMessageDialog(RulesDialog.this, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        dialog.reset();
    }//GEN-LAST:event_buttonAddRuleActionPerformed

    private void buttonActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActivateActionPerformed
        List<Rule> rules = listAvailableRules.getSelectedValuesList();
        if(rules.isEmpty())
            return;
                
        ruleManager.activateRules(rules);
        saveRules();
    }//GEN-LAST:event_buttonActivateActionPerformed

    private void buttonDeactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeactivateActionPerformed
        List<Rule> rules = listActiveRules.getSelectedValuesList();
        if(rules.isEmpty())
            return;
        
        ruleManager.deactivateRules(rules);
        saveRules();
    }//GEN-LAST:event_buttonDeactivateActionPerformed

    private void onListAvailableRulesValueChangedEvent(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onListAvailableRulesValueChangedEvent
        if(listAvailableRules.isSelectionEmpty()) {
            buttonActivate.setEnabled(false);
            buttonRemove.setEnabled(false);
            buttonAvailableMoveUp.setEnabled(false);
            buttonAvailableMoveDown.setEnabled(false);
        }
        else {
            buttonActivate.setEnabled(true);
            buttonRemove.setEnabled(true);
            buttonAvailableMoveUp.setEnabled(true);
            buttonAvailableMoveDown.setEnabled(true);
        }
    }//GEN-LAST:event_onListAvailableRulesValueChangedEvent

    private void onListActiveRulesValueChangedEvent(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onListActiveRulesValueChangedEvent
        if(listActiveRules.isSelectionEmpty()) {
            buttonDeactivate.setEnabled(false);
            buttonActiveMoveUp.setEnabled(false);
            buttonActiveMoveDown.setEnabled(false);
        }
        else {
            buttonDeactivate.setEnabled(true);
            buttonActiveMoveUp.setEnabled(true);
            buttonActiveMoveDown.setEnabled(true);
        }
    }//GEN-LAST:event_onListActiveRulesValueChangedEvent

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        List<Rule> rules = listAvailableRules.getSelectedValuesList();
        if(rules.isEmpty())
            return;
        
        ruleManager.removeRules(rules);
        saveRules();
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonAvailableMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAvailableMoveUpActionPerformed
        int index = listAvailableRules.getSelectedIndex();
        
        if(index != -1 && index > 0) {
            ruleManager.swapAvailableRules(index - 1, index);
            listAvailableRules.setSelectedIndex(index - 1);
            saveRules();
        }
    }//GEN-LAST:event_buttonAvailableMoveUpActionPerformed

    private void buttonAvailableMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAvailableMoveDownActionPerformed
        int index = listAvailableRules.getSelectedIndex();
        
        if(index != -1 && index < ruleManager.getAvailableRules().size() - 1) {
            ruleManager.swapAvailableRules(index + 1, index);
            listAvailableRules.setSelectedIndex(index + 1);
            saveRules();
        }
    }//GEN-LAST:event_buttonAvailableMoveDownActionPerformed

    private void buttonActiveMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActiveMoveUpActionPerformed
        int index = listActiveRules.getSelectedIndex();
        
        if(index != -1 && index > 0) {
            ruleManager.swapActiveRules(index - 1, index);
            listActiveRules.setSelectedIndex(index - 1);
            saveRules();
        }
    }//GEN-LAST:event_buttonActiveMoveUpActionPerformed

    private void buttonActiveMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActiveMoveDownActionPerformed
        int index = listActiveRules.getSelectedIndex();
        
        if(index != -1 && index < ruleManager.getActiveRules().size() - 1) {
            ruleManager.swapActiveRules(index + 1, index);
            listActiveRules.setSelectedIndex(index + 1);
            saveRules();
        }
    }//GEN-LAST:event_buttonActiveMoveDownActionPerformed

    private void listAvailableRulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAvailableRulesMouseClicked
        if(evt.getClickCount() == 2) {
            Rule rule = listAvailableRules.getSelectedValue();
            if(rule == null)
                return;
            
            ruleManager.activateRule(rule);
            saveRules();
        }
    }//GEN-LAST:event_listAvailableRulesMouseClicked

    private void listActiveRulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listActiveRulesMouseClicked
        if(evt.getClickCount() == 2) {
            Rule rule = listActiveRules.getSelectedValue();
            if(rule == null)
                return;
            
            ruleManager.deactivateRule(rule);
            saveRules();
        }
    }//GEN-LAST:event_listActiveRulesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActivate;
    private javax.swing.JButton buttonActiveMoveDown;
    private javax.swing.JButton buttonActiveMoveUp;
    private javax.swing.JButton buttonAddRule;
    private javax.swing.JButton buttonAvailableMoveDown;
    private javax.swing.JButton buttonAvailableMoveUp;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonDeactivate;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JComboBox<String> comboRuleTypes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelRuleType;
    private javax.swing.JList<domain.Rule> listActiveRules;
    private javax.swing.JList<domain.Rule> listAvailableRules;
    // End of variables declaration//GEN-END:variables
}
