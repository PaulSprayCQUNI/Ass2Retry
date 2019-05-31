/*
 * GUI code for Ass1, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: FSAAppFrame.java
 // Date: April 26 2019
 // Purpose: COIT11134 Assignment One
 // Task 2 of Assignment Specifications
 */
package FSAApp;

// necessary imports packages
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Begin class for Frame that opens first when program runs
public class FSAAppFrame extends JFrame {

    /* create variables of types JButton, JTextField, and JPanels for first Frame.
   First 3 buttons create the same Frame, with appropriate conditions applied */
    private JButton enterRoomBtn;       //button to create Frame for RoomRental
    private JButton enterWholeBtn;      //button to create Frame for WholeRental    
    private JButton editRentalBtn;      //button to create Frame to edit an entry
    private JButton displayRentalBtn;   // button to create Frame to display entries
    private JButton exitBtn;            // button to exit first Frame, close program
    private JButton delBtn;            // button to exit first Frame, close program
    private JTextField textId;          // textField corresponding to edit button
    private JTextField deleteId;          // textField corresponding to del button
    private JPanel pnlMainBtns;         // panel for each button
    private JPanel pnlMainEdit;
    private JPanel pnlMainDelete;
    private JPanel pnlMainExit;
    private JPanel pnlMainDisp;
    private JPanel pnlCentre;           // panel to align button panels on

    /* an ArrayList called rentals created of the type Rental to store 
    values for the abstract super class Rental  */
    private ArrayList<Rental> rentals;
    private int rentalEditIndex;


    /* create constructor for laying out components onto the first Frame*/
    public FSAAppFrame() {

        /* initialise the ArrayList rentals*/
        rentals = new ArrayList<Rental>();

        try {
            RentalReader rentalReader = new RentalReader("FSA_Availability.csv");
            rentals = rentalReader.getRentals();

        } catch (RentalFileNotFoundException e) {
            System.out.println("No such filename exists, creating file in path." + e);
            System.exit(1);
        }

        /* add components for FSAAppFrame - apply layout for panels within Frame*/
        pnlMainBtns = new JPanel();
        pnlMainDisp = new JPanel();
        pnlMainEdit = new JPanel();
        pnlMainDelete = new JPanel();
        pnlMainExit = new JPanel();
        pnlCentre = new JPanel();
        pnlCentre.setLayout(new GridLayout(3, 1));

        /* apply BorderLayout for whole Frame*/
        this.setLayout(new BorderLayout());

        /*construct buttons and text field and adding AcionListener actions to
        call private methods further below when event occurs for each button*/
        enterRoomBtn = new JButton("Room Rental");
        enterRoomBtn.addActionListener(new EnterRoomBtnAction());

        enterWholeBtn = new JButton("Whole Rental");
        enterWholeBtn.addActionListener(new EnterWholeBtnAction());

        editRentalBtn = new JButton("Edit Rental of Id:");
        editRentalBtn.addActionListener(new EditBtnAction());
        textId = new JTextField("", 6);
        delBtn = new JButton("Delete Rental of Id:");
        delBtn.addActionListener(new DelBtnAction());
        deleteId = new JTextField("", 6);

        displayRentalBtn = new JButton("Display");
        displayRentalBtn.addActionListener(new DisplayBtnAction());

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ExitBtnAction());

        /* add buttons to panel pnlMainBtns, JTextField textId to  pnlMainEdit,
        and pnlMainBtns + pnlMainEdit to frame*/
        pnlMainBtns.add(enterRoomBtn);
        pnlMainBtns.add(enterWholeBtn);
        pnlMainDisp.add(displayRentalBtn);
        pnlMainEdit.add(editRentalBtn);
        pnlMainEdit.add(textId);
        pnlMainDelete.add(delBtn);
        pnlMainDelete.add(deleteId);
        pnlMainExit.add(exitBtn);

        /* add panels of buttons to panels for the Frame layout*/
        pnlCentre.add(pnlMainBtns);
        pnlCentre.add(pnlMainDisp);
        pnlCentre.add(pnlMainEdit);
        pnlCentre.add(pnlMainDelete);

        /* add pnaels for the Frame layout to the Frame BorderLayout*/
        this.add(pnlCentre, BorderLayout.CENTER);
        this.add(pnlMainExit, BorderLayout.SOUTH);

    }// end of constructor for first frame // end of constructor for first frame

    private class DelBtnAction implements ActionListener {

        /* method for deleting a entry for an Rental Id entered into the textfield on the welcome screen, also asks
        user if they are sure they want to delete the entry */
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Start Confirmation to delete dialog");
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want Delete the entry?", "",
                    JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                System.out.println("Start check Id is valid");
                if (rentals.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Rentals Entered");

                } else {
                    int i = 0;
                    System.out.println(i);
                    while (i < rentals.size() && !rentals.get(i).getRentalID().equals(textId.getText())) {
                        System.out.println(i);
                        i++;
                    }
                    if (i == rentals.size()) {
                        JOptionPane.showMessageDialog(null, "No such Id exists in the list",
                                "", JOptionPane.ERROR_MESSAGE);

                    } else {
                        System.out.println("Remove found rentals element");
                        rentalEditIndex = i;
                        rentals.remove(i);
                    }

                }
//                dispose();
                
            }
        } // end method
    }   // end exit button pressed class

    /* adding of the classes that operate the implements ActionListener function
    in order to peform the required methods based on the button action*/
 /*default class for action completed in event of Exit button pressed */
    private class ExitBtnAction implements ActionListener {

        /* method for exit button needs to ask the 
        user if they are sure they want to exit */
        @Override
        public void actionPerformed(ActionEvent event) {

            int confirmed = JOptionPane.showConfirmDialog(null,
                    "If you want to Exit - Select Yes.\n Select No to go back", "Thank you for using the FSA Program",
                    JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                dispose();
                RentalWriter rentalListWriter = new RentalWriter("FSA_Availability.csv", rentals);
                System.exit(0);
            }
        } // end method
    }   // end exit button pressed class

    /* method from line 126 to dispose (hide) first frame and create DisplayFrame,
    is called from DisplayBtnAction class further below in code. 
    This method and the methods to create a Frame for edit, new RoomRental,
    and new WholeRental determine what the form fields are set as in the 
    created Frame based on the String userAction. The object used to store 
    what is read in is an object rentals of the ArrayList of type Rental.  */
    private void goToDisplayFrame(String userAction) {

        /* advanced for loop to check title of current 
        Frame and call dispose() method */
        for (Frame f : Frame.getFrames()) {
            if (f.getTitle().equals("FSA Rental Program - Welcome")) {
                f.dispose();
            }
        }
        /* remainder of method creates and sets Visible the
        required new DisplayFrame */
        DisplayFrame frame = new DisplayFrame(rentals, userAction);
        frame.setTitle("Displaying all Rentals");
        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Friendly Student Accommodation App", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    RentalWriter rentalListWriter = new RentalWriter("FSA_Availability.csv", rentals);
                    System.exit(0);
                }
            }
        });

    }   // end method

    /* method for disposing of opening frame and creating a frame to appear 
    for event of enterRoomBtn, enterWholeBtn, or editRentalBtn being pushed. 
    Triggered by override methods within private classes for each action*/
    private void goToEnterEditFrame(String userAction) {

        /* advanced for loop to hide first Frame */
        for (Frame f : Frame.getFrames()) {
            if (f.getTitle().equals("FSA Rental Program - Welcome")) {
                f.dispose();
            }
        }
        /* Create a new EnterEditFrame */
        EnterEditFrame frame = new EnterEditFrame(rentals, userAction, rentalEditIndex);
        frame.setTitle("Enter or Update Rental");
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Friendly Student Accommodation App", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    RentalWriter rentalListWriter = new RentalWriter("FSA_Availability.csv", rentals);
                    System.exit(0);
                }
            }
        });

    } // end method

    /* private nested classes accessible only to the class of the first Frame that
    implement ActionListener and carry out methods that call to the methods 
    to create the next relevant Frame and do so with the required argument 
    for String userAction*/
    private class EnterRoomBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            goToEnterEditFrame("newRoom");
        } //end method for creating a Frame for a RoomRental
    } //end private nested class

    private class EnterWholeBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            goToEnterEditFrame("newWhole");
        } //end method for creating a Frame for a WholeRental
    } // end private nested class

    private class EditBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            /* if else statment within this class checks if the ArrayList 
            is empty, and shows an error if it is (i.e no rentals have been 
            recorded yet. The else calls the method to create  a new Frame with
            the argument for String user Action as edit     */
            if (rentals.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Rentals Entered");

            } else {
                int i = 0;
                System.out.println(i);
                while (i < rentals.size() && !rentals.get(i).getRentalID().equals(textId.getText())) {
                    System.out.println(i);
                    i++;
                }
                if (i == rentals.size()) {
                    JOptionPane.showMessageDialog(null, "No such Id exists in the list",
                            "", JOptionPane.ERROR_MESSAGE);

                } else {
                    rentalEditIndex = i;
                    goToEnterEditFrame("edit");
                }

            } // end if else statment
        }   // end method
    }   //end private nested class

    private class DisplayBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            /* same function as above if else, but for showing an error if there
            are no rentals to display in the Display Frame yet */

            if (rentals.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Rentals Entered");

            } else {
                goToDisplayFrame("Display");
            } //end if else statement
        }   // end method
    }   //  end private nested class
}       // end of the class for the first Frame
