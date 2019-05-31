/*
 * GUI code for Ass2, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: RentalFileNotFoundException.java
 // Date: May 31 2019
 // Purpose: COIT11134 Assignment Two
 // Task 6 of Assignment Specifications for Phase 2
// Exception handler related to RentalReader and RentalWriter
 */
package FSAApp;

import java.io.IOException;

/**
 *
 * @author 12084819
 */
public class RentalFileNotFoundException extends IOException {

    public RentalFileNotFoundException() {
    }

    public RentalFileNotFoundException(String message) {
        super("Something wrong with format: " + message);
    }
}