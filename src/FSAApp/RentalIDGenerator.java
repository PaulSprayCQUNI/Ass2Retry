// Programmer: Paul Spray S1208419
 // File: RentalIDGenerator.java
 // Date: May 31 2019
 // Purpose: COIT11134 Assignment Two
 // Task from Assignment Specifications from Phase 1(Assignment One) implemented for Assignment Two
 
package FSAApp;

/**
 *
 * @author 12084819
 */
public class RentalIDGenerator {

    private static int rentalCounter = 1000;
    private String rentalType;

    /**
     * Get the value of rentalType
     *
     * @return the value of rentalType
     */
    public String getRentalType() {
        return rentalType;
    }

    /**
     * Set the value of rentalType
     *
     * @param rentalType new value of rentalType
     */
    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    /**
     * Get the value of rental
     *
     * @return the value of rental
     */
    public static int getRentalCounter() {
        return rentalCounter;
    }

    /**
     * Set the value of rentalCounter
     *
     * @param rentalCounter new value of rentalCounter
     */
    public static void setRentalCounter(int rentalCounter) {
        RentalIDGenerator.rentalCounter = rentalCounter;
    }
/* incrementation to ensure each time getRoomRentalId() or getWholeRentalId()
    are called from other classes, the starting value of rental counter is incremented
    and no number is generated twich
    */
    public static void increment() {
        rentalCounter++;
    }

    public static String getRoomRentalId() {
        rentalCounter++;
        return "R" + rentalCounter;
    }

    public static String getWholeRentalId() {
        rentalCounter++;
        return "W" + rentalCounter;
    }
}
