/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

        customFornmat(String pattern, double number)

        customFormat("###,###.##", 123456.789);  // output -> 123,456.79
        customFormat("###,###.###", 123456.789);  // output -> 123,456.789
        customFormat("###.##", 123456.789);       // output -> 123456.79
        customFormat("000000.000", 123.78);   // output -> 000123.780
        customFormat("$###,###,###", 12345.67); // output-> 12,345.67
 */
package util;

import java.text.DecimalFormat;

/**
 *
 * @author vicente-jpro
 */
public class Numerario {

    private Number number;
    
    // Separar o número 123456.789 na forma -> 123,456.79
    private String pattern = "###,###.##"; 
    
    private DecimalFormat myFormatter;
   
    public Numerario(Number number){
    
    this.number = number;
    
        this.myFormatter = new DecimalFormat(pattern);
       
    
    }
    
    public String getNumberFormated(){
        
        return  myFormatter.format(number);
        
    }
    
    
    
}
