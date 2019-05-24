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
import java.awt.EventQueue;
import javax.swing.JFrame;

// beginning of class   
public class FSAApp {

// main method
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {                  // defers the running of the main method code until all pending events are processed
            FSAAppFrame frame = new FSAAppFrame();
            frame.setTitle("FSA Rental Program - Welcome");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setVisible(true);
            frame.setResizable(true);
        });     
    }   // end main method

}   // end of class FSAApp
