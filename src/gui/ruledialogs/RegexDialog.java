package gui.ruledialogs;

import domain.Rule;
import domain.exceptions.InvalidException;
import domain.rules.RuleRegex;
import java.awt.Frame;
import javax.swing.JOptionPane;

public class RegexDialog extends RuleDialog {
    private Rule rule;
    
    public RegexDialog(Frame parent) {
        super(parent);
        initComponents();
        
        setLocationRelativeTo(parent);
        setTitle("Regex");
        
        registerInputField("name", textfieldName);
        registerInputField("regex", textfieldRegex);
    }
    
    @Override
    public Rule getRule() {
        return rule;
    }
    
    @Override
    public void reset() {
        textfieldName.setText("");
        textfieldRegex.setText("");
        textfieldReplacement.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        labelRegex = new javax.swing.JLabel();
        labelReplacement = new javax.swing.JLabel();
        textfieldName = new javax.swing.JTextField();
        textfieldRegex = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        textfieldReplacement = new javax.swing.JTextField();
        buttonAddRule = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter values"));

        labelRegex.setText("Regex");

        labelReplacement.setText("Replacement");

        textfieldName.setName(""); // NOI18N

        labelName.setText("Name");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRegex)
                    .addComponent(labelReplacement)
                    .addComponent(labelName))
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(textfieldReplacement)
                    .addComponent(textfieldRegex))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(textfieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRegex)
                    .addComponent(textfieldRegex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelReplacement)
                    .addComponent(textfieldReplacement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonAddRule.setText("Add Rule");
        buttonAddRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddRuleActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
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
                        .addComponent(buttonAddRule)
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
                    .addComponent(buttonAddRule)
                    .addComponent(buttonCancel))
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
            String regex = textfieldRegex.getText();
            String replacement = textfieldReplacement.getText();
            
//            regex = regex.replaceAll(" ", "?");
//            replacement = replacement.replaceAll(" ", "?");

            rule = new RuleRegex(name, regex, replacement);
            dispose();
        } catch(InvalidException ex) {
            JOptionPane.showMessageDialog(RegexDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonAddRuleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddRule;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelRegex;
    private javax.swing.JLabel labelReplacement;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textfieldName;
    private javax.swing.JTextField textfieldRegex;
    private javax.swing.JTextField textfieldReplacement;
    // End of variables declaration//GEN-END:variables
}
