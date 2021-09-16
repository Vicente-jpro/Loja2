/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Words;

/**
 *
 * @author vicente-jpro
 */
public class DeleteLastLetter {

    private String frase;
    
    public DeleteLastLetter ( String frase ){
        
        this.frase = frase;
    }
    
    /**
     * @return This method return a new phrase without the last leter. EX:
     * Phrase "Angola". It returns "Angol"
     */
    public String getNovaFrase() {

        String novaFrase = "";
        for (int i = 0; i < frase.length(); i++) {
            
            if ( (i + 1) != frase.length()) {
                String letra = Character.toString(frase.charAt(i));
                novaFrase += letra;
            }
            
        }

        return novaFrase.trim();
    }
    
    
    
}
