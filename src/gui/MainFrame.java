package gui;

import domain.EditHistory;
import domain.EditSession;
import domain.IIMListener;
import domain.Item;
import domain.ItemManager;
import domain.Rule;
import domain.exceptions.InvalidException;
import domain.RuleManager;
import domain.exceptions.RuleExistException;
import gui.ruledialogs.DisplaySaveDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import technical.FileManager;

public class MainFrame extends JFrame implements IIMListener {
    private static final String FILE_DIRECTORY = "fdir.dat";
    private static final String SAVE_DIRECTORY = "sdir.dat";
    private static final String ACTIVE_RULES = "acrules.dat";
    private static final String AVAILABLE_RULES = "avrules.dat";
    
    private ItemManager itemManager = new ItemManager();
    private RuleManager ruleManager = new RuleManager();
    private EditHistory editHistory = new EditHistory();
    
    public MainFrame() {
        initComponents();
        
        listFiles.setCellRenderer(new ListItemCellRenderer(ListItemCellRenderer.ITEM_NORMAL));
        
        setTitle("FileRenamer");
        setLocationRelativeTo(null);
        try {            
            if(FileManager.fileExist(AVAILABLE_RULES))
                ruleManager.addRules((List<Rule>)FileManager.load(AVAILABLE_RULES));
            
            if(FileManager.fileExist(ACTIVE_RULES))
                ruleManager.activateRules((List<Rule>)FileManager.load(ACTIVE_RULES));
            
            if(FileManager.fileExist(SAVE_DIRECTORY)) {
                String filename = (String)FileManager.load(SAVE_DIRECTORY);
                if(FileManager.isDirectory(filename))
                    textfieldFilepath.setText(filename);
            }
            
        } catch (FileNotFoundException | ClassNotFoundException | RuleExistException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        itemManager.registerListener(this);
    }
    
    @Override
    public void itemChanged() {
        int[] indices = listFiles.getSelectedIndices();
        
        DefaultListModel<Item> model = new DefaultListModel();
        for(Item item : itemManager.getItems())
            model.addElement(item);
        listFiles.setModel(model);
        listFiles.setSelectedIndices(indices);  
        
        buttonUndo.setEnabled(editHistory.hasUndos());
        buttonRedo.setEnabled(editHistory.hasRedos());
        buttonSave.setEnabled(itemManager.hasChanges());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        buttonChooseFiles = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonRules = new javax.swing.JButton();
        panelFiles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFiles = new javax.swing.JList<domain.Item>();
        panelCommands = new javax.swing.JPanel();
        buttonRename = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonChooseFilepath = new javax.swing.JButton();
        textfieldFilepath = new javax.swing.JTextField();
        buttonEdit = new javax.swing.JButton();
        buttonUndo = new javax.swing.JButton();
        buttonRedo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        buttonChooseFiles.setText("Choose files...");
        buttonChooseFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseFilesActionPerformed(evt);
            }
        });

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonRules.setText("Rules");
        buttonRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRulesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonChooseFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRules, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonChooseFiles)
                .addComponent(buttonExit)
                .addComponent(buttonRules))
        );

        panelFiles.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected files"));

        listFiles.setToolTipText("");
        listFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listFilesMouseClicked(evt);
            }
        });
        listFiles.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onListFilesValueChangedEvent(evt);
            }
        });
        jScrollPane1.setViewportView(listFiles);

        javax.swing.GroupLayout panelFilesLayout = new javax.swing.GroupLayout(panelFiles);
        panelFiles.setLayout(panelFilesLayout);
        panelFilesLayout.setHorizontalGroup(
            panelFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelFilesLayout.setVerticalGroup(
            panelFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFilesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCommands.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        buttonRename.setText("Rename");
        buttonRename.setEnabled(false);
        buttonRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRenameActionPerformed(evt);
            }
        });

        buttonRemove.setText("Remove");
        buttonRemove.setEnabled(false);
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        buttonSave.setText("Save");
        buttonSave.setEnabled(false);
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonChooseFilepath.setText("Choose filepath...");
        buttonChooseFilepath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseFilepathActionPerformed(evt);
            }
        });

        textfieldFilepath.setEnabled(false);
        textfieldFilepath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldFilepathActionPerformed(evt);
            }
        });

        buttonEdit.setText("Edit");
        buttonEdit.setEnabled(false);
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonUndo.setText("Undo");
        buttonUndo.setEnabled(false);
        buttonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUndoActionPerformed(evt);
            }
        });

        buttonRedo.setText("Redo");
        buttonRedo.setEnabled(false);
        buttonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRedoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCommandsLayout = new javax.swing.GroupLayout(panelCommands);
        panelCommands.setLayout(panelCommandsLayout);
        panelCommandsLayout.setHorizontalGroup(
            panelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCommandsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRename, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(buttonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCommandsLayout.createSequentialGroup()
                        .addComponent(buttonUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(buttonRemove))
                    .addGroup(panelCommandsLayout.createSequentialGroup()
                        .addComponent(buttonRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCommandsLayout.createSequentialGroup()
                        .addComponent(buttonChooseFilepath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textfieldFilepath, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCommandsLayout.setVerticalGroup(
            panelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCommandsLayout.createSequentialGroup()
                .addGroup(panelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRemove)
                    .addComponent(buttonSave)
                    .addComponent(buttonChooseFilepath)
                    .addComponent(buttonUndo)
                    .addComponent(buttonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCommandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldFilepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRedo)
                    .addComponent(buttonRename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCommands, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCommands, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonChooseFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseFilesActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        
        if(FileManager.fileExist(FILE_DIRECTORY)) {
            try {
                String filename = (String)FileManager.load(FILE_DIRECTORY);
                if(FileManager.isDirectory(filename))
                    fc.setCurrentDirectory(new File(filename));
            } catch (ClassNotFoundException | IOException ex) {
                JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(fc.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
            itemManager.addItems(fc.getSelectedFiles()); 
            
            try {
                FileManager.save(FILE_DIRECTORY, fc.getCurrentDirectory().getPath());
                if(textfieldFilepath.getText().isEmpty()) {
                    textfieldFilepath.setText(fc.getCurrentDirectory().getPath());
                    FileManager.save(SAVE_DIRECTORY, fc.getCurrentDirectory().getPath());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonChooseFilesActionPerformed

    private void onListFilesValueChangedEvent(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onListFilesValueChangedEvent
        buttonRename.setEnabled(!listFiles.isSelectionEmpty());
        buttonRemove.setEnabled(!listFiles.isSelectionEmpty());
        buttonEdit.setEnabled(!listFiles.isSelectionEmpty());
    }//GEN-LAST:event_onListFilesValueChangedEvent

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        List<Item> selectedItems = listFiles.getSelectedValuesList();
        if(selectedItems.isEmpty())
            return;
        
        editHistory.removeItems(selectedItems);
        itemManager.removeItems(selectedItems);
        listFiles.clearSelection();
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRenameActionPerformed
        List<Item> selectedItems = listFiles.getSelectedValuesList();
        if(selectedItems.isEmpty())
            return;
        
        try {
            EditSession session = new EditSession();
            for(Item item : selectedItems) {
                item.applyRules(ruleManager.getActiveRules());
                session.remember(item);
            }
            editHistory.rembember(session);
            editHistory.clearRedos();
            
            itemChanged();
        } catch( InvalidException ex) {
            JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonRenameActionPerformed

    private void buttonRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRulesActionPerformed
        RulesDialog dialog = new RulesDialog(this, ruleManager);
        ruleManager.registerListener(dialog);
        dialog.setVisible(true);
    }//GEN-LAST:event_buttonRulesActionPerformed

    private void textfieldFilepathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldFilepathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldFilepathActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        List<Item> selectedItems = listFiles.getSelectedValuesList();
        if(selectedItems.isEmpty())
            return;
        
        new ItemEditDialog(this, selectedItems, editHistory);
        itemChanged();
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUndoActionPerformed
        EditSession session = editHistory.undo();
        for(Item item : session.getItems())
            item.undo();       
        itemChanged();
    }//GEN-LAST:event_buttonUndoActionPerformed

    private void buttonRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRedoActionPerformed
        EditSession session = editHistory.redo();
        for(Item item : session.getItems())
            item.redo();
        itemChanged();
    }//GEN-LAST:event_buttonRedoActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        new DisplaySaveDialog(this, itemManager, textfieldFilepath.getText());
        
        itemChanged();
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonChooseFilepathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseFilepathActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(textfieldFilepath.getText()));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            textfieldFilepath.setText(fc.getSelectedFile().getPath());
            try {
                FileManager.save(SAVE_DIRECTORY, fc.getSelectedFile().getPath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonChooseFilepathActionPerformed

    private void listFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listFilesMouseClicked
        if(evt.getClickCount() == 2) {
            List<Item> items = new ArrayList();
            Item item = listFiles.getSelectedValue();
            items.add(item);
            
            new ItemEditDialog(this, items, editHistory);
            itemChanged();
        }
    }//GEN-LAST:event_listFilesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseFilepath;
    private javax.swing.JButton buttonChooseFiles;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonRedo;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonRename;
    private javax.swing.JButton buttonRules;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonUndo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<domain.Item> listFiles;
    private javax.swing.JPanel panelCommands;
    private javax.swing.JPanel panelFiles;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTextField textfieldFilepath;
    // End of variables declaration//GEN-END:variables
}
