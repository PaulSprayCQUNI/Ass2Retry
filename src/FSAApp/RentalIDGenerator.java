/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
