/*
 * Child class code for Ass1, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: WholeRental.java
 // Date: April 26 2019
 // Purpose: COIT11134 Assignment One
 // Task 1 of Assignment Specifications
 */
package FSAApp;

/**
 *
 * class WholeRental as an extend of the abstract super class Rental, for
 * storing attributes that are too specific to be part of the super class, but
 * are distinct from those required for a RoomRental
 */
public class WholeRental extends Rental {

    // variables for this class
    private int numRooms;
    private int numBathrooms;
    private boolean hasGarage;
    private boolean petsAllowed;

    /*default and parametised constructors for the WholeRental Class, 
    plus a third constructor with arguments included from the Parent Class */
    public WholeRental() {
        this.numRooms = 0;
        this.numBathrooms = 0;
        this.hasGarage = false;
        this.petsAllowed = false;
    }

    public WholeRental(int numRooms, int numBathrooms, boolean hasGarage,
            boolean petsAllowed, String rentalID, Address address,
            double weeklyPrice, boolean furnished, String description) {
        super(rentalID, address, weeklyPrice, furnished, description);
        this.numRooms = numRooms;
        this.numBathrooms = numBathrooms;
        this.hasGarage = hasGarage;
        this.petsAllowed = petsAllowed;
    }

    public WholeRental(int numRooms, int numBathrooms, boolean hasGarage,
            boolean petsAllowed) {
        this.numRooms = numRooms;
        this.numBathrooms = numBathrooms;
        this.hasGarage = hasGarage;
        this.petsAllowed = petsAllowed;
    }
    // end of constructors for this class

    //-->> beginning of set and get methods for the variables of this class
    /**
     * Get the value of petsAllowed
     *
     * @return the value of petsAllowed
     */
    public boolean arePetsAllowed() {
        return petsAllowed;
    }

    /**
     * Set the value of petsAllowed
     *
     * @param petsAllowed new value of petsAllowed
     */
    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    /**
     * Get the value of hasGarage
     *
     * @return the value of hasGarage
     */
    public boolean isHasGarage() {
        return hasGarage;
    }

    /**
     * Set the value of hasGarage
     *
     * @param hasGarage new value of hasGarage
     */
    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    /**
     * Get the value of numBathrooms
     *
     * @return the value of numBathrooms
     */
    public int getNumBathrooms() {
        return numBathrooms;
    }

    /**
     * Set the value of numBathrooms
     *
     * @param numBathrooms new value of numBathrooms
     */
    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    /**
     * Get the value of numRooms
     *
     * @return the value of numRooms
     */
    public int getNumRooms() {
        return numRooms;
    }

    /**
     * Set the value of numRooms
     *
     * @param numRooms new value of numRooms
     */
    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }
// <<-- end of set and get methods for this class

    // toString output method for class RoomRental
    @Override
    public String toString() {
        return super.toString() + "Number of Rooms in House: " + numRooms
                + " \nNumber of Bathrooms: " + numBathrooms
                + ", \nGarage Parking: " + hasGarage
                + " \nPets Allowed: " + petsAllowed + "\n";
    }// end of output to String()

}// end of class WholeRental
