/*
 * Child class code for Ass2, COIT11134
 *  *
/ Programmer: Paul Spray S1208419
 // File: RoomRental.java
 // Date: May 31 2019
 // Purpose: COIT11134 Assignment Two
 // Task 1 of Assignment Specifications for Phase 1
 */
package FSAApp;

/**
 *
 * @author 12084819
 */
public class RoomRental extends Rental {

    /* variables to hold data that are specific to the child-class 
    and not inherited from the Parent Class and are disintinct from the 
    attributes required for a WholeRental*/
    private boolean couplesAllowed;
    private boolean hasEnsuite;

    /*default and parametised constructors for the RoomRental Class, 
    plus a third constructor with arguments included from the Parent Class */
    public RoomRental() {
        this.couplesAllowed = false;
        this.hasEnsuite = false;
    }

    public RoomRental(boolean couplesAllowed, boolean hasEnsuite) {
        this.couplesAllowed = couplesAllowed;
        this.hasEnsuite = hasEnsuite;
    }

    public RoomRental(String rentalID, Address address, double weeklyPrice, boolean furnished,
            String description, boolean couplesAllowed, boolean hasEnsuite) {
        super(rentalID, address, weeklyPrice, furnished, description);
        this.couplesAllowed = couplesAllowed;
        this.hasEnsuite = hasEnsuite;
    } // end constructors

    // begin set and get methods for variables of this class -->>
    public boolean areCouplesAllowed() {
        return couplesAllowed;
    }

    public void setCouplesAllowed(boolean couplesAllowed) {
        this.couplesAllowed = couplesAllowed;
    }

    public boolean hasEnsuite() {
        return hasEnsuite;
    }

    public void setHasEnsuite(boolean hasEnsuite) {
        this.hasEnsuite = hasEnsuite;
    }
// <<-- end of set and get methods

    // toString output method for class RoomRental
    @Override
    public String toString() {
        return super.toString() + "Couples are Allowed: "
                + couplesAllowed + " \nEnsuite to Room: " + hasEnsuite + "\n";
    }// end of output to String()

} // end of class RoomRental
