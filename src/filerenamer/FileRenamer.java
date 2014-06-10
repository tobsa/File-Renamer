package filerenamer;

import domain.exceptions.RuleExistException;
import gui.MainFrame;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileRenamer {

    public static void main(String[] args) throws RuleExistException, FileNotFoundException, ClassNotFoundException {
        setLookAndFeel();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
                frame.setVisible(true);
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
