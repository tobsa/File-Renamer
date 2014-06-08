package filerenamer;

import domain.Rule;
import domain.RuleManager;
import domain.exceptions.RuleExistException;
import domain.rules.RuleRegex;
import gui.MainFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import technical.FileManager;

public class FileRenamer {

    public static void main(String[] args) throws RuleExistException, FileNotFoundException, ClassNotFoundException {
//        try {
//            if(FileManager.fileExist("avrules.dat")) {
//                RuleManager ruleManager = (RuleManager)FileManager.load("avrules.dat");
//                
//                for(Rule rule : ruleManager.getAvailableRules())
//                    System.out.println(rule.getName());
//                
//                
//            }
//            else {
//                RuleManager ruleManager = new RuleManager();
//
//                ruleManager.addRule(new RuleRegex("derp", "a", "b"));
//
//                FileManager.save("avrules.dat", ruleManager);
//                System.out.println("Saved!");
//            }
//            
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
        
        setLookAndFeel();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
