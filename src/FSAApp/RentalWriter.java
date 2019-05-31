/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    //  private ArrayList<Rental> rentals;
    private static Formatter output;

    public RentalWriter(String fileName, ArrayList<Rental> rentals) {

        // Open the output file
        try {
            output = new Formatter(fileName);
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening the file. Terminating.");
            System.exit(1);
        }

        String rentalID;
        System.out.println("Writing the rentals");
        // Write people to file
        for (Rental r : rentals) {
            System.out.println("Checking inside the for loop");

            if (r instanceof WholeRental) {
                System.out.println("Writing a whole rental");
                WholeRental wr = (WholeRental) r;
                output.format("%s,%s,%s,%s,%s,%s,%.2f,%b,%s,%d,%d,%b,%b\n", r.getRentalID(),
                        r.getAddress().getStreetNumber(), r.getAddress().getStreetName(),
                        r.getAddress().getCityName(), r.getAddress().getPostCode(), r.getAddress().getState(),
                        r.getWeeklyPrice(), r.isFurnished(), r.getDescription(), ((WholeRental) r).getNumRooms(),
                        ((WholeRental) r).getNumBathrooms(), ((WholeRental) r).isHasGarage(), ((WholeRental) r).arePetsAllowed());

            } else if (r instanceof RoomRental) {
                System.out.println("Writing a room rental");
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
