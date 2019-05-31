/*
 * Parent class code for Ass1, COIT11134
 *  *
 // Programmer: Paul Spray S1208419
 // File: Rental.java
 // Date: April 26 2019
 // Purpose: COIT11134 Assignment One
 // Task 1 of Assignment Specifications
 */
package FSAApp;

/**
 * Rental is the abstract super class for this program
 */
public abstract class Rental {          // beginning of class Rental

    /* creation of variables for attributes that are generic for the two
    rental property types */
    private String rentalID;
    private Address address;
    private double weeklyPrice;
    private boolean furnished;
    private String description;

    /* Default constructor for Rental and instatiation of variables 
    to null values. To an object of class Address in the case of the variable
    address    */
    public Rental() {
        this.rentalID = "";
        this.address = new Address();
        this.weeklyPrice = 0.00;
        this.furnished = false;
        this.description = "";
    }

    /* parametised constructor for Rental for generic attributes, 
    including parameter of address of type Addresss */
    public Rental(String rentalID, Address address, double weeklyPrice,
            boolean furnished, String description) {
        this.rentalID = rentalID;
        this.address = address;
        this.weeklyPrice = weeklyPrice;
        this.furnished = furnished;
        this.description = description;
    }

    /* parametised constructor for Rental using generic attributes as
    parameters and parameters of the class Address. variable address is assigned
    as an object of type Address in this constructor */
    public Rental(String rentalID, String streetNumber, String streetName,
            String cityName, String postCode, String state, double weeklyPrice,
            boolean furnished, String description) {
        this.rentalID = rentalID;
        this.address = new Address();
        this.weeklyPrice = weeklyPrice;
        this.furnished = furnished;
        this.description = description;
    }
// beginning of set and get methods -->>
    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of furnished
     *
     * @return the value of furnished
     */
    public boolean isFurnished() {
        return furnished;
    }

    /**
     * Set the value of furnished
     *
     * @param furnished new value of furnished
     */
    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Get the value of rentalID
     *
     * @return the value of rentalID
     */
    public String getRentalID() {
        return rentalID;
    }

    /**
     * Set the value of rentalID
     *
     * @param rentalID new value of rentalID
     */
    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    /**
     * Get the value of weeklyPrice
     *
     * @return the value of weeklyPrice
     */
    public double getWeeklyPrice() {
        return weeklyPrice;
    }

    /**
     * Set the value of weeklyPrice
     *
     * @param weeklyPrice new value of weeklyPrice
     */
    public void setWeeklyPrice(double weeklyPrice) {
        this.weeklyPrice = weeklyPrice;
    }
// <<-- end of set and get methods
    
   // method to output variables of this class by a toString method

    @Override
    public String toString() {
      return "\n" + "RentalID:" + rentalID + "\n" 
                + address + "\n" + "Weekly Price: $"+ String.format("%.2f",weeklyPrice) +
                 " \nFurnished: " + furnished + " \nDescription: "
                + description + "\n";
        
        
        /*
        ("\n" + "RentalID:" + rentalID + "\n" 
                + address + "\n" + "Weekly Price: $"+ weeklyPrice +
                 " \nFurnished: " + furnished + " \nDescription: "
                + description + "\n");*/
    }

} // end of abstract super class Rental
