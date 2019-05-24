/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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