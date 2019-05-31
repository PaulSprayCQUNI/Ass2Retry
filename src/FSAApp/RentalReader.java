/*
 * To change this license header, choose License Headers in Project Prorerties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FSAApp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author 12084819
 */
public class RentalReader {

    private ArrayList<Rental> rentals;
    private static Scanner fileScanner;

    public RentalReader(String fileName) throws RentalFileNotFoundException {

        // Open the file
        try {
            fileScanner = new Scanner(Paths.get(fileName));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }

        // Initialise list of rentals
        rentals = new ArrayList<>();
        String rentalID;

        // Read file line-by-line
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            // Get the current line 
            Scanner lineScanner = new Scanner(line);

            // Set separator to comma
            lineScanner.useDelimiter(",");

            // Read the fields from line into person
            try {
                rentalID = lineScanner.next();
// rentalID,streetNumber,streetName,cityName,postCode,state,weeklyPrice,furnished,description,couplesAllowed,hasEnsuite,numRooms,numBathrooms,hasGarage,petsAllowed
                if (rentalID.startsWith("R")) {
                    RoomRental rr = new RoomRental();
                    rr.setRentalID(rentalID);
                    rr.setAddress(new Address(lineScanner.next(), lineScanner.next(), lineScanner.next(), lineScanner.next(), lineScanner.next()));
                    rr.setWeeklyPrice(Double.parseDouble(lineScanner.next()));
                    rr.setFurnished(Boolean.parseBoolean(lineScanner.next()));
                    rr.setDescription(lineScanner.next());
                    rr.setCouplesAllowed(Boolean.parseBoolean(lineScanner.next()));
                    rr.setHasEnsuite(Boolean.parseBoolean(lineScanner.next()));
                    rentals.add(rr);
                } else {
                    WholeRental wr = new WholeRental();
                    wr.setRentalID(rentalID);
                    wr.setAddress(new Address(lineScanner.next(), lineScanner.next(), lineScanner.next(), lineScanner.next(), lineScanner.next()));
                    wr.setWeeklyPrice(Double.parseDouble(lineScanner.next()));
                    wr.setFurnished(Boolean.parseBoolean(lineScanner.next()));
                    wr.setDescription(lineScanner.next());
                    wr.setNumRooms(Integer.parseInt(lineScanner.next()));
                    wr.setNumBathrooms(Integer.parseInt(lineScanner.next()));
                    wr.setHasGarage(Boolean.parseBoolean(lineScanner.next()));
                    wr.setPetsAllowed(Boolean.parseBoolean(lineScanner.next()));
                    rentals.add(wr);
                }

            } // Wrong format of fields
            catch (IllegalArgumentException e) {
                System.err.println("Error reading file due to illegal argument. Terminating.");
                System.exit(1);
            } // File formatted incorrectly
            catch (NoSuchElementException e) {
                System.err.println("Error reading file due to no such element. Terminating.");
                System.exit(1);
            } // If you remove the following catch, then this error will be caught in the main

            // Add the rental to array
            
            // Close the line
            lineScanner.close();
        }

        // Close the file
        fileScanner.close();
    }

    // Getter methods
    public ArrayList<Rental> getRentals() {
        return rentals;
    }
}
