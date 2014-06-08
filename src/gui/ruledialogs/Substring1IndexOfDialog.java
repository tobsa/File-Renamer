package gui.ruledialogs;

import domain.exceptions.InvalidException;
import domain.Rule;
import domain.rules.RuleSubstringIndexOf;
import java.awt.Frame;
import javax.swing.JOptionPane;

public class Substring1IndexOfDialog extends RuleDialog {
    private Rule rule;
    
    public Substring1IndexOfDialog(Frame parent) {
        super(parent);
        initComponents();
        
        setLocationRelativeTo(parent);
        setTitle("Substring1IndexOf");
        
        registerInputField("name", textfieldName);
        registerInputField("index", textfieldIndex);
    }
    
    @Override
    public Rule getRule() {
        return rule;
    }

    @Override
    public void reset() {
        textfieldName.setText("");
        textfieldIndex.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        labelIndex = new javax.swing.JLabel();
        textfieldName = new javax.swing.JTextField();
        textfieldIndex = new javax.swing.JTextField();
        checkboxIncludeIndex = new javax.swing.JCheckBox();
        buttonCancel = new javax.swing.JButton();
        buttonAddRule = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter values"));

        labelName.setText("Name");

        labelIndex.setText("Index");

        checkboxIncludeIndex.setText("Include index");
        checkboxIncludeIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxIncludeIndexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelName)
                    .addComponent(labelIndex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldName)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(textfieldIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxIncludeIndex)
                        .addGap(0, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(textfieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIndex)
                    .addComponent(checkboxIncludeIndex))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonAddRule.setText("Add Rule");
        buttonAddRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddRuleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAddRule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonAddRule))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        rule = null;
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonAddRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddRuleActionPerformed
        try {
            validateInputFields();

            String name = textfieldName.getText();
            String indexText = textfieldIndex.getText();

            rule = new RuleSubstringIndexOf(name, indexText, checkboxIncludeIndex.isSelected());
            dispose();
        } catch (InvalidException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(Substring1IndexOfDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonAddRuleActionPerformed

    private void checkboxIncludeIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxIncludeIndexActionPerformed

    }//GEN-LAST:event_checkboxIncludeIndexActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddRule;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JCheckBox checkboxIncludeIndex;
    private javax.swing.JLabel labelIndex;
    private javax.swing.JLabel labelName;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textfieldIndex;
    private javax.swing.JTextField textfieldName;
    // End of variables declaration//GEN-END:variables
}
