/*
 * GUI code for Ass1, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: FSAApp.java
 // Date: April 26 2019
 // Purpose: COIT11134 Assignment One
 // Task 2 of Assignment Specifications
 */
package FSAApp;

/**
 *
 * FSAApp.java contains the public class FSAApp that allows a main method
 * required for the program to run and create the first Frame, which is
 * populated by the code of the class FSAAppFrame
 */
// necessary imports packages
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// beginning of class   
public class FSAApp {

// main method
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {                  // defers the running of the main method code until all pending events are processed
            FSAAppFrame frame = new FSAAppFrame();
            frame.setTitle("FSA Rental Program - Welcome");
            frame.setSize(600, 400);
            frame.setVisible(true);
            frame.setResizable(true);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    String ObjButtons[] = {"Yes", "No"};
                    int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Friendly Student Accommodation App", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                    if (PromptResult == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            });

        });
    }   // end main method

}   // end of class FSAApp
