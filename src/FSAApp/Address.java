/*
 * 
 * Code to enable polymorphism for the elements required for a rental address

 // Programmer: Paul Spray S1208419
 // File: Address.java
 // Date: May 31 2019
 // Purpose: COIT11134 Assignment Two
 // Task 3 and 4 of Assignment Specifications from Phase 1(Assignment One)
 */
package FSAApp;

/**
 *
 * class Address created to break-down object of type Address in class Rental
 * into 5 appropriate variables of type String to be entered by the user
 */
public class Address {

    private String streetNumber;
    private String streetName;
    private String cityName;
    private String postCode;
    private String state;

    public Address() {
        this.streetNumber = "";
        this.streetName = "";
        this.cityName = "";
        this.postCode = "";
        this.state = "";
    }

    public Address(String streetNumber, String streetName, String cityName, String postCode, String state) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.postCode = postCode;
        this.state = state;
    }

    /** Beginning of set and get methods -->>
     * Get the value of state
     *
     * @return the value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the value of postCode
     *
     * @return the value of postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Set the value of postCode
     *
     * @param postCode new value of postCode
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Get the value of cityName
     *
     * @return the value of cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Set the value of cityName
     *
     * @param cityName new value of cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Get the value of streetName
     *
     * @return the value of streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Set the value of streetName
     *
     * @param streetName new value of streetName
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Get the value of streetNumber
     *
     * @return the value of streetNumber
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Set the value of streetNumber
     *
     * @param streetNumber new value of streetNumber
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
//  <<-- end of set and get methods
    
    // method to output variables of this class by a toString method
    @Override
    public String toString() {
        return "Address: "  + streetNumber + ", " + streetName + ", \n" 
                + cityName + ", " + postCode + ", " + state ;
    }

} // end of Address class
