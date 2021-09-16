/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JOptionPane;

/**
 * @author vicente-jpro
 *
 * This class contains constructor CharNumberASII(String validateNumber) that
 * resive a number to validate.
 *
 */
public class CharNumberASII {

    private String validateNumber = "";

    public CharNumberASII(String validateNumber) {
        this.validateNumber = validateNumber;

    }

    /*  
 * @return 
 * 
 * The method getStringNumber() validate the number receved on constructor.
 *   Ex: "1234RTc". 
 * It's return "1234" in string format.
 * 
    ERROR: throws NumberFormatException if there is no number
 *  
     */
    public String getStringNumber() throws NumberFormatException {

        // End of string Ex: "1234RTc".  end = 7
        int end = validateNumber.length();

        if (end <= 1) {
            return null;
        } else {
            // Beguin of string ex: "1234RTc" beguin = 0;
            int beguin = 0;

            // Search all String
            while (beguin < end) {

                // In ASCII table 48 corresponde "0" in decimal and 57 corresponde "9"
                if (validateNumber.codePointAt(beguin) >= 48 && validateNumber.codePointAt(beguin) <= 57) {
                    beguin++;
                } else {
                    break; // Break the loop because it found a diferente simbolo
                }
            }
            // Beguin going to have the last index of String "4"  
            end = beguin;
        }
        // return "1234" 
        return validateNumber.substring(0, end);
    }

}
