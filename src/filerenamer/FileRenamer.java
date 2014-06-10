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
        
//        String d = "hej på dig";
//        String e = d.replaceAll("\\?", "_");
//        
//        System.out.println(e);
        
        
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
