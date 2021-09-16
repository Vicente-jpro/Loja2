/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * @see  This class delete space from string 
 *          using the method remove().
 * @author vicente-jpro
 */
public class RemoveSpace {
    
    private String str;
    
    public RemoveSpace (){
    
    }
    
    /**
     *
     * @return This method remove any space in string 
     * ex: Angola is a beautiful country. ItreturnsAngolaisabeautifulcountry  
     * 
     */
    public String remove(String str) throws NullPointerException{
    
        this.str = str;
        
        int end = str.length();
        
        int position = 0;
        String word = "";
        while ( position < end){
        
        String letter = String.valueOf( str.charAt( position ) );
            
            if( !letter.equalsIgnoreCase( " " )   )
                word += letter;
            position++;
        }
    
        return word;
    }
    
}
