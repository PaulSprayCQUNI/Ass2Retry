/*
 * GUI code for 2, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: DisplayFrame.java
 // Date: May 31 2019
 // Purpose: COIT11134 Assignment Two
 // Task 3 of Assignment Specifications from Phase 1(Assignment One)
// Tasks 5 implemented for Phase 2(Assignment Two)- all rental properties display
 */
package FSAApp;

// necessary imports packages
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * class DisplayFrame to provide for the layout and construction of the frame to
 * appear when user presses display in the first frame.
 */
public class DisplayFrame extends JFrame {

    /*
    Gui elements for construction of fream
     */
    private JButton backBtn;
    private JTextArea displayTextArea;
    private JScrollPane displayScrollPane;

    private JPanel pnlDisplayArea;
    private JPanel pnlDispButtons;
    private JPanel pnlCenter;
    private JPanel pnlSouth;

    /* an ArrayList called rentals created of the type Rental to store 
    values for the abstract super class Rental  */
    private ArrayList<Rental> rentals;
    private String userAction;

    // begin constructor for this frame
    public DisplayFrame(ArrayList<Rental> rentals, String userAction) {

        /* instatiate object of ArrayList and String argument referring to the
        button action captured in class FSAApp */
        this.rentals = rentals;
        this.userAction = userAction;

        // set Layout for the frame and place components in the GUI
        this.setLayout(new BorderLayout());

        pnlCenter = new JPanel();
        pnlCenter.setLayout(new FlowLayout());
        pnlSouth = new JPanel();
        pnlSouth.setLayout(new FlowLayout());

        displayTextArea = new JTextArea(16, 38);
        displayScrollPane = new JScrollPane(displayTextArea);
        displayScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pnlDisplayArea = new JPanel();
        pnlDisplayArea.add(displayScrollPane);

        // add the only button for this frame and define method to be called by action    
        backBtn = new JButton("Back");
        backBtn.addActionListener(new BackButtonAction());

        pnlDispButtons = new JPanel();
        pnlDispButtons.add(backBtn);

        pnlCenter.add(pnlDisplayArea);
        pnlSouth.add(pnlDispButtons);

        this.add(pnlCenter, BorderLayout.NORTH);
        this.add(pnlSouth, BorderLayout.SOUTH);

        /* String object to be used in advance for loop that attains the values
        of an object of class Rental, and outputs values of the toString() methods
        of the Rental, RoomRental, and WholeRental classes */
        String s = "";

        for (Rental r : this.rentals) {
            s = s + "PROPERTY DETAILS: \n ----------------------------------------\n"
                    + r.toString() + "----------------------------------------\n";
        }
        // apend the String object s to the JTextArea of this frame
        displayTextArea.append(String.format(s));

    }
// method to be executed when the back button is pushed

    private void returnToWelcomeFrame() {
        for (Frame f : Frame.getFrames()) {
            if (f.getTitle().equals("Displaying all Rentals")) {
                f.dispose();
            }
            if (f.getTitle().equals("FSA Rental Program - Welcome")) {
                f.setVisible(true);
            }
        }

    }// end of method
    
    // call to the method above that is required when back button is pushed
    private class BackButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            returnToWelcomeFrame();

        } // end of actionPerformed() for back button

    } // end of class containing back button actionPerformed()
} // end of class DisplayFrame
