/*
 * GUI code for Ass1, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: EnterEditFrame.java
 // Date: April 26 2019
 // Purpose: COIT11134 Assignment One
 // Task 3 of Assignment Specifications
 */
package FSAApp;

// necessary imports packages
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 *
 * class EnterEditFrame handles the construction of the frame used for providing
 * an option for the user to select to enter either type of rental, and to edit
 * the last recorded rental. The code will be modified at a later date to
 * provide a search and retrieve function of any previously entered rental for
 * the edit action in the first frame.
 */
public class EnterEditFrame extends JFrame {

    // begin creating components for upper detail section of the frame
    private JLabel rentalIdLbl;
    private JTextField idTxtFld;

    private JLabel stNumLbl;
    private JTextField stNumTxtFld;

    private JLabel stNameLbl;
    private JTextField stNameTxtFld;

    private JLabel cityLbl;
    private JTextField cityTxtFld;

    private JLabel pstCodeLbl;
    private JTextField pstCodeTxtFld;

    private JLabel stateNameLbl;
    private JTextField stateNameTxtFld;

    private JLabel weeklyPriceLbl;
    private JTextField weeklyPriceTxtFld;

    private JLabel descriptionLbl;
    private JTextField descriptionTxtFld;

    // radio buttons and groups for the middle section of the frame
    private JRadioButton furnRadBtn;
    private JRadioButton unfurnRadBtn;
    private ButtonGroup furnGroup;

    private JRadioButton cplsAllwdRadBtn;
    private JRadioButton nocplsAllwdRadBtn;
    private ButtonGroup cplsGroup;

    private JRadioButton hasEnsuiteRadBtn;
    private JRadioButton noEnsuiteRadBtn;
    private ButtonGroup ensuiteGroup;

    private JLabel numRmsLbl;
    private JTextField numRmsTxtFld;

    private JLabel numBathRmsLbl;
    private JTextField numBathRmsTxtFld;

    private JRadioButton hasGarageRadBtn;
    private JRadioButton noGarageRadBtn;
    private ButtonGroup garageGroup;

    private JRadioButton petsAllwdRadBtn;
    private JRadioButton nopetsAllwdRadBtn;
    private ButtonGroup petsGroup;

    //  use these panels in constructor to add components in respective groups
    private JPanel pnlDetail;
    private JPanel pnlDetailGrid;
    private JPanel pnlCenterGrid;

    private JPanel pnlOptions;
    private JPanel pnlFurnOption;
    private JPanel pnlRmOptions;
    private JPanel pnlHouseOptions;

    // panels and buttons required for navigational button at bottom section
    private JPanel pnlSouth;
    private JPanel pnlESubmit;
    private JPanel pnlEBack;
    private JPanel pnlEClear;
    private JButton backBtn;
    private JButton submitBtn;
    private JButton clearBtn;

    /* an ArrayList called rentals created of the type Rental to store 
    values for the abstract super class Rental
    And an object of String called userAction for use in determining 
    what fields are active in the frame based on what button was pushed in 
    the first frame of the program*/
    private ArrayList<Rental> rentals;
    private String userAction;

    // begin constructor for this frame    
    public EnterEditFrame(ArrayList<Rental> rentals, String userAction) {

        /* instatiate object of ArrayList and String argument referring to the
        button action captured in class FSAApp */
        this.rentals = rentals;
        this.userAction = userAction;

        // layout for the EnterEditFrame
        this.setLayout(new BorderLayout());

        //create Panels and set their layouts for the top section of frame
        pnlDetail = new JPanel();
        pnlDetail.setLayout(new FlowLayout());
        pnlDetailGrid = new JPanel();
        pnlDetailGrid.add(pnlDetail);
        pnlDetailGrid.setLayout(new GridLayout(1, 1, 1, 1));

        // create components for the top section of frame
        rentalIdLbl = new JLabel("Rental ID");
        idTxtFld = new JTextField(6);
        stNumLbl = new JLabel("Street No.");
        stNumTxtFld = new JTextField(4);
        stNameLbl = new JLabel("Street Name");
        stNameTxtFld = new JTextField(20);
        cityLbl = new JLabel("City/Town");
        cityTxtFld = new JTextField(20);
        pstCodeLbl = new JLabel("Post Code");
        pstCodeTxtFld = new JTextField(4);
        stateNameLbl = new JLabel("State/Territory");
        stateNameTxtFld = new JTextField(4);
        weeklyPriceLbl = new JLabel("Weekly Price e.g: 100.00");
        weeklyPriceTxtFld = new JTextField(4);
        descriptionLbl = new JLabel("Property Description");
        descriptionTxtFld = new JTextField(20);
        numRmsLbl = new JLabel("Rooms in House");
        numRmsTxtFld = new JTextField(2);
        numBathRmsLbl = new JLabel("Bathrooms in House");
        numBathRmsTxtFld = new JTextField(2);

        // add the created top section components to the panels 
        pnlDetail.add(rentalIdLbl);
        pnlDetail.add(idTxtFld);
        idTxtFld.setEditable(false);
        pnlDetail.add(stNumLbl);
        pnlDetail.add(stNumTxtFld);
        pnlDetail.add(stNameLbl);
        pnlDetail.add(stNameTxtFld);
        pnlDetail.add(cityLbl);
        pnlDetail.add(cityTxtFld);
        pnlDetail.add(pstCodeLbl);
        pnlDetail.add(pstCodeTxtFld);
        pnlDetail.add(stateNameLbl);
        pnlDetail.add(stateNameTxtFld);
        pnlDetail.add(descriptionLbl);
        pnlDetail.add(descriptionTxtFld);
        pnlDetail.add(weeklyPriceLbl);
        pnlDetail.add(weeklyPriceTxtFld);
        pnlDetail.add(numRmsLbl);
        pnlDetail.add(numRmsTxtFld);
        pnlDetail.add(numBathRmsLbl);
        pnlDetail.add(numBathRmsTxtFld);

        // panels for middle section for optionals buttons
        pnlOptions = new JPanel();
        pnlOptions.setLayout(new GridLayout(5, 1, 1, 1));
        pnlFurnOption = new JPanel();
        pnlFurnOption.setLayout(new FlowLayout());
        pnlRmOptions = new JPanel();
        pnlRmOptions.setLayout(new FlowLayout());

        /*create components and their default values for the middle section.
        Also add listeners for RadioButtons, and add components of middle section
        to panels created in above rows 174-179 */
        furnRadBtn = new JRadioButton("Furnished", false);
        unfurnRadBtn = new JRadioButton("Unfurnished", false);
        furnGroup = new ButtonGroup();
        furnGroup.add(furnRadBtn);
        furnRadBtn.addItemListener(new RadioButtonHandler());
        furnGroup.add(unfurnRadBtn);
        unfurnRadBtn.addItemListener(new RadioButtonHandler());
        pnlFurnOption.add(furnRadBtn);
        pnlFurnOption.add(unfurnRadBtn);
        cplsAllwdRadBtn = new JRadioButton("Couples Allowed", false);
        nocplsAllwdRadBtn = new JRadioButton("No Couples Allowed", false);
        cplsGroup = new ButtonGroup();
        cplsGroup.add(cplsAllwdRadBtn);
        cplsAllwdRadBtn.addItemListener(new RadioButtonHandler());
        cplsGroup.add(nocplsAllwdRadBtn);
        nocplsAllwdRadBtn.addItemListener(new RadioButtonHandler());
        pnlFurnOption.add(furnRadBtn);
        pnlFurnOption.add(unfurnRadBtn);
        pnlRmOptions.add(cplsAllwdRadBtn);
        pnlRmOptions.add(nocplsAllwdRadBtn);
        pnlHouseOptions = new JPanel();
        pnlHouseOptions.setLayout(new FlowLayout());
        hasEnsuiteRadBtn = new JRadioButton("Ensuite", false);
        noEnsuiteRadBtn = new JRadioButton("No Ensuite", false);
        ensuiteGroup = new ButtonGroup();
        ensuiteGroup.add(hasEnsuiteRadBtn);
        hasEnsuiteRadBtn.addItemListener(new RadioButtonHandler());
        ensuiteGroup.add(noEnsuiteRadBtn);
        noEnsuiteRadBtn.addItemListener(new RadioButtonHandler());
        pnlRmOptions.add(hasEnsuiteRadBtn);
        pnlRmOptions.add(noEnsuiteRadBtn);
        hasGarageRadBtn = new JRadioButton("Garage", false);
        noGarageRadBtn = new JRadioButton("No Garage", false);
        garageGroup = new ButtonGroup();
        garageGroup.add(hasGarageRadBtn);
        hasGarageRadBtn.addItemListener(new RadioButtonHandler());
        garageGroup.add(noGarageRadBtn);
        noGarageRadBtn.addItemListener(new RadioButtonHandler());
        petsAllwdRadBtn = new JRadioButton("Pets Allowed", false);
        nopetsAllwdRadBtn = new JRadioButton("No Pets Allowed", false);
        petsGroup = new ButtonGroup();
        petsGroup.add(petsAllwdRadBtn);
        petsAllwdRadBtn.addItemListener(new RadioButtonHandler());
        petsGroup.add(nopetsAllwdRadBtn);
        nopetsAllwdRadBtn.addItemListener(new RadioButtonHandler());
        pnlHouseOptions.add(hasEnsuiteRadBtn);
        pnlHouseOptions.add(noEnsuiteRadBtn);
        pnlHouseOptions.add(hasGarageRadBtn);
        pnlHouseOptions.add(noGarageRadBtn);
        pnlHouseOptions.add(petsAllwdRadBtn);
        pnlHouseOptions.add(nopetsAllwdRadBtn);
        pnlOptions.add(pnlFurnOption);
        pnlOptions.add(pnlRmOptions);
        pnlOptions.add(pnlHouseOptions);

        /* panels for bottom of frame section for buttons, and listener
        functions for buttons to call to required methods for Submit, Back
        and Clear  */
        pnlSouth = new JPanel();
        pnlSouth.setLayout(new FlowLayout());
        pnlESubmit = new JPanel();
        pnlEBack = new JPanel();
        pnlEClear = new JPanel();
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new SubmitButtonAction());
        backBtn = new JButton("Back");
        backBtn.addActionListener(new BackButtonAction());
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new ClearButtonAction());
        pnlESubmit.add(submitBtn);
        pnlEBack.add(backBtn);
        pnlEClear.add(clearBtn);
        pnlSouth.add(pnlESubmit);
        pnlSouth.add(pnlEClear);
        pnlSouth.add(pnlEBack);

        // created final Panel to add upper and middle sections to
        pnlCenterGrid = new JPanel();
        pnlCenterGrid.setLayout(new GridLayout(2, 1, 1, 1));
        pnlCenterGrid.add(pnlDetailGrid);
        pnlCenterGrid.add(pnlOptions);
        /* placing panel containting upper and middle section to center of 
        BorderLayout and panel containing navigational buttons to BorderLayout
        south*/
        this.add(pnlCenterGrid, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        /* if statement series that obtains the attribute values stored to the 
        object of Rental r in the ArrayList rentals and populates the fields
        of this frame when the Edit button is pushed on the first frame of the 
        program */
        if (userAction.equals("edit")) {
            Rental r = rentals.get(0);

            idTxtFld.setText(r.getRentalID());
            stNumTxtFld.setText(r.getAddress().getStreetNumber());
            stNameTxtFld.setText(r.getAddress().getStreetName());
            cityTxtFld.setText(r.getAddress().getCityName());
            pstCodeTxtFld.setText(r.getAddress().getPostCode());
            stateNameTxtFld.setText(r.getAddress().getState());
            weeklyPriceTxtFld.setText(Double.toString(r.getWeeklyPrice()));
            descriptionTxtFld.setText(r.getDescription());
            furnRadBtn.setSelected(r.isFurnished());

            /* type check that type of Rental object r is a Whole Rental 
            and convert r to whole rental  */
            // taking values per rr and wr respectively by use of if, else if
            if (r instanceof WholeRental) {
                WholeRental wr = (WholeRental) r;
                hasEnsuiteRadBtn.setEnabled(false);
                noEnsuiteRadBtn.setEnabled(false);
                cplsAllwdRadBtn.setEnabled(false);
                nocplsAllwdRadBtn.setEnabled(false);
                numRmsTxtFld.setText(Integer.toString(wr.getNumRooms()));
                numBathRmsTxtFld.setText(Integer.toString(wr.getNumBathrooms()));
                hasGarageRadBtn.setSelected(wr.isHasGarage());
                petsAllwdRadBtn.setSelected((wr.arePetsAllowed()));

            } else if (r instanceof RoomRental) {
                RoomRental rr = (RoomRental) r;
                numRmsLbl.setEnabled(false);
                numRmsTxtFld.setEnabled(false);
                numRmsTxtFld.setEditable(false);
                numBathRmsLbl.setEnabled(false);
                numBathRmsTxtFld.setEnabled(false);
                numBathRmsTxtFld.setEditable(false);
                hasGarageRadBtn.setEnabled(false);
                noGarageRadBtn.setEnabled(false);
                petsAllwdRadBtn.setEnabled(false);
                nopetsAllwdRadBtn.setEnabled(false);
                cplsAllwdRadBtn.setSelected(rr.areCouplesAllowed());
                hasEnsuiteRadBtn.setSelected(rr.hasEnsuite());

            }

        } // end of if statement for userAction of "edit"

        // begin if statement for the creation of the frame for a Room Rental 
        if (userAction.equals("newRoom")) {
            numRmsLbl.setEnabled(false);
            numRmsTxtFld.setEnabled(false);
            numRmsTxtFld.setEditable(false);
            numBathRmsLbl.setEnabled(false);
            numBathRmsTxtFld.setEnabled(false);
            numBathRmsTxtFld.setEditable(false);
            hasGarageRadBtn.setEnabled(false);
            noGarageRadBtn.setEnabled(false);
            petsAllwdRadBtn.setEnabled(false);
            nopetsAllwdRadBtn.setEnabled(false);

        } // end of Room Rental if statement

        // begin if statement for the creation of the frame for a Whole Rental 
        if (userAction.equals("newWhole")) {
            hasEnsuiteRadBtn.setEnabled(false);
            noEnsuiteRadBtn.setEnabled(false);
            cplsAllwdRadBtn.setEnabled(false);
            nocplsAllwdRadBtn.setEnabled(false);

        }

    }

    /* method saveFormDetails() called by action of button to Submit being
    pressed in the frame EnterEditFrame    */
    private void saveFormDetails() {
        /* construct new empty Rental r, Whole wr or Room Rental rr to be stored to 
        ArrayList rentals of type Rental */
        Rental r;
        RoomRental rr;
        WholeRental wr;

        /* read values from form - first code is to check all fields for 
        attributes of classes Rental and Address or a radiobutton option is 
        selected - prompts specific errors if there is no entry or selection,
        or value is of wrong type*/
        if (stNumTxtFld.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a street Number",
                    "", JOptionPane.ERROR_MESSAGE);
            stNumTxtFld.requestFocus();
        }
        if (stNameTxtFld.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a street Name",
                    "", JOptionPane.ERROR_MESSAGE);
            stNameTxtFld.requestFocus();
        }

        if (cityTxtFld.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a city/town Name",
                    "", JOptionPane.ERROR_MESSAGE);
            cityTxtFld.requestFocus();
        }

        if (pstCodeTxtFld.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a Post Code",
                    "", JOptionPane.ERROR_MESSAGE);
            pstCodeTxtFld.requestFocus();
        }

        if (stateNameTxtFld.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a State",
                    "", JOptionPane.ERROR_MESSAGE);
            stateNameTxtFld.requestFocus();
        }

        if (descriptionTxtFld.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Please descripe the Rental",
                    "", JOptionPane.ERROR_MESSAGE);
            descriptionTxtFld.requestFocus();
        }

        /* variable for following if else statment and try catch to check 
        if price field contains an entry and that it is of type double*/
        double weeklyPriceVal;
        if (weeklyPriceTxtFld.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a price in format"
                    + " 100.00",
                    "", JOptionPane.ERROR_MESSAGE);
            weeklyPriceTxtFld.requestFocus();
        } else {
            try {
                weeklyPriceVal = Double.parseDouble(weeklyPriceTxtFld.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a price in"
                        + " format 100.00",
                        "", JOptionPane.ERROR_MESSAGE);
                weeklyPriceTxtFld.requestFocus();
            }

        }

        if (!furnRadBtn.isSelected() && (!unfurnRadBtn.isSelected())) {
            JOptionPane.showMessageDialog(null, "Please select option to"
                    + " show if Furnished",
                    "", JOptionPane.ERROR_MESSAGE);
            furnRadBtn.requestFocus();
        }
        /* end values checking for fields of attributes from super class
         Rental and Address class */

        if (userAction.equals("newRoom")) {
            /* values checking for fields of attributes from child class RoomRental*/

            if (!cplsAllwdRadBtn.isSelected() && (!nocplsAllwdRadBtn.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please select option to"
                        + " show if Couples are Allowed",
                        "", JOptionPane.ERROR_MESSAGE);
                cplsAllwdRadBtn.requestFocus();
            }
            if (!hasEnsuiteRadBtn.isSelected() && (!noEnsuiteRadBtn.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please select option to"
                        + " show if Room has an Ensuite",
                        "", JOptionPane.ERROR_MESSAGE);
                hasEnsuiteRadBtn.requestFocus();
            } // end values checking for RoomRental entry
            // objects for setting of RoomRental values to object of Rentals r
            rr = new RoomRental();
            r = rr;
            rr.setCouplesAllowed(cplsAllwdRadBtn.isSelected());
            rr.setHasEnsuite(hasEnsuiteRadBtn.isSelected());

            // else statement continues above checking of entries for Whole Rental
        } else {

            /* variable for following if else statment and try catch to check 
        if numRooms field contains an entry and that it is of type integer*/
            int numRoomsVal;
            if (numRmsTxtFld.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Please enter number of "
                        + "Rooms in House",
                        "", JOptionPane.ERROR_MESSAGE);
                numRmsTxtFld.requestFocus();
            } else {
                try {
                    numRoomsVal = Integer.parseInt(numRmsTxtFld.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter number of "
                            + "Rooms as Whole Number",
                            "", JOptionPane.ERROR_MESSAGE);
                    numRmsTxtFld.requestFocus();
                }

            }
            /* variable for following if else statment and try catch to check 
        if numBathRooms field contains an entry and that it is of type integer*/
            int numBathsVal;
            if (numBathRmsTxtFld.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Please enter number of "
                        + "Bathrooms in House",
                        "", JOptionPane.ERROR_MESSAGE);
                numBathRmsTxtFld.requestFocus();
            } else {
                try {
                    numBathsVal = Integer.parseInt(numBathRmsTxtFld.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter number of "
                            + "Bathrooms in House",
                            "", JOptionPane.ERROR_MESSAGE);
                    numBathRmsTxtFld.requestFocus();
                }

            }

            if (!hasGarageRadBtn.isSelected() && (!noGarageRadBtn.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please select option for Garage",
                        "", JOptionPane.ERROR_MESSAGE);
                hasGarageRadBtn.requestFocus();
            }

            if (!petsAllwdRadBtn.isSelected() && (!nopetsAllwdRadBtn.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please select option "
                        + " to show if Pets are Allowed",
                        "", JOptionPane.ERROR_MESSAGE);
                petsAllwdRadBtn.requestFocus();
            }// end of checking values for Whole Rental

            // objects for setting of WholeRental values to object of Rentals r
            wr = new WholeRental();
            r = wr;
            wr.setNumRooms(Integer.parseInt(numRmsTxtFld.getText()));
            wr.setNumBathrooms(Integer.parseInt(numBathRmsTxtFld.getText()));
            wr.setHasGarage(hasGarageRadBtn.isSelected());
            wr.setPetsAllowed(petsAllwdRadBtn.isSelected());

        }
        // object of Address class required to use get methods of that class
        Address a = new Address();

        r.setRentalID(idTxtFld.getText()); //only used a place holder for this program
        a.setStreetNumber(stNumTxtFld.getText());
        a.setStreetName(stNameTxtFld.getText());
        a.setCityName(cityTxtFld.getText());
        a.setPostCode(pstCodeTxtFld.getText());
        a.setState(stateNameTxtFld.getText());
        // attributes of Address return to setAddress() of object of Rental r
        r.setAddress(a);
        r.setWeeklyPrice(Double.parseDouble(weeklyPriceTxtFld.getText()));
        r.setFurnished(furnRadBtn.isSelected());
        r.setDescription(descriptionTxtFld.getText());

        /* return r as the Rental object to ArrayList rentals*/
        rentals.add(0, r);
    }

    /* private classes and methods to handle ActionListener events for buttons
    of this frame begin here as well as a default method of ItemListener for
    the radio buttons */
    private class SubmitButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            saveFormDetails();          // call to saveFormDetails when Submit button pressed
            /* all actions in this frame return to first frame of program after
            executing the required code */
            returnToWelcomeFrame();

        }
    }

    private void returnToWelcomeFrame() {
        for (Frame f : Frame.getFrames()) {
            if (f.getTitle().equals("Enter or Update Rental")) {
                f.dispose();
            }
            if (f.getTitle().equals("FSA Rental Program - Welcome")) {
                f.setVisible(true);
            }
        }

    }

    private class RadioButtonHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

        }

    }

    private class BackButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            returnToWelcomeFrame();

        }
    }

    private class ClearButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // clear fields, reset button groups to null

            stNumTxtFld.setText("");
            stNameTxtFld.setText("");
            cityTxtFld.setText("");
            pstCodeTxtFld.setText("");
            stateNameTxtFld.setText("");
            weeklyPriceTxtFld.setText("");
            descriptionTxtFld.setText("");
            numRmsTxtFld.setText("");
            numBathRmsTxtFld.setText("");
            furnGroup.clearSelection();
            cplsGroup.clearSelection();
            ensuiteGroup.clearSelection();
            garageGroup.clearSelection();
            petsGroup.clearSelection();
            stNumTxtFld.requestFocus();

        }
    }   // end of private classes of this frame
}   // end of class EnterEditFrame
