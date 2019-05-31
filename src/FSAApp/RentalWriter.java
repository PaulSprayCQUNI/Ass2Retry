/*
 * GUI code for Ass2, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: RentalWriter.java
 // Date: May 31 2019
 // Purpose: COIT11134 Assignment Two
 // Task 6 of Assignment Specifications for Phase 2
// reference - code derived from FileOps2 package shown in class by S.Gordon

 */
package FSAApp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author 12084819
 */
public class RentalWriter {

    private static Formatter output;

    public RentalWriter(String fileName, ArrayList<Rental> rentals) {

        // Open the output file
        try {
            output = new Formatter(fileName);

            /* catches if the source file has been set to read only or if    
            the file has been erroneously named or is one the program should
            not access    */
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening the file. Terminating.");
            System.exit(1);
        }

        String rentalID;

        // Write rentals to file
        for (Rental r : rentals) {

            if (r instanceof WholeRental) {

                WholeRental wr = (WholeRental) r;
                output.format("%s,%s,%s,%s,%s,%s,%.2f,%b,%s,%d,%d,%b,%b\n", r.getRentalID(),
                        r.getAddress().getStreetNumber(), r.getAddress().getStreetName(),
                        r.getAddress().getCityName(), r.getAddress().getPostCode(), r.getAddress().getState(),
                        r.getWeeklyPrice(), r.isFurnished(), r.getDescription(), ((WholeRental) r).getNumRooms(),
                        ((WholeRental) r).getNumBathrooms(), ((WholeRental) r).isHasGarage(), ((WholeRental) r).arePetsAllowed());

            } else if (r instanceof RoomRental) {

                output.format("%s,%s,%s,%s,%s,%s,%.2f,%b,%s,%b,%b\n", r.getRentalID(),
                        r.getAddress().getStreetNumber(), r.getAddress().getStreetName(),
                        r.getAddress().getCityName(), r.getAddress().getPostCode(), r.getAddress().getState(),
                        r.getWeeklyPrice(), r.isFurnished(), r.getDescription(), ((RoomRental) r).areCouplesAllowed(), ((RoomRental) r).hasEnsuite());

            }
        }

        // Close the file
        output.close();
    }
}
