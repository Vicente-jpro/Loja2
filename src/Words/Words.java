/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Words;

/**
 *
 * @author SynAck
 */
public class Words {

    private static final Words instance = new Words();
    private String[] array = new String[100];

    private Words() {
    }

    public static Words getInstance() {

        return instance;
    }

    /**
     *
     * @param str
     * @return This method convert all firt letter in the word toUpperCase. Ex:
     * "angola is a beautiful country" it retuns "Angola Is A Bealtifull
     * Country".
     * 
     * retun a string.
     * Vicente Simão Java Programmer
     */
    public String toUpperCaseAllFirsLetter(String str) {

        String word = null;
        try {

            char nomeChar = 0;

            for (int i = 0; i < str.length(); i++) {

                // get the element at position i
                nomeChar = str.charAt(i);
                if (i == 0) {
                    // get the element at the first position, trasform toUpperCase, and put it into array
                    array[i] = String.valueOf(nomeChar)
                            .toUpperCase();
                } else if (" ".equals(String.valueOf(str.charAt(i)))) {  // espaço corresponde a 32

                    // get the space at position i
                    nomeChar = str.charAt(i);
                    // put the space into array
                    array[i] = String.valueOf(nomeChar);
                    // skip used position on array and put the next element before the space 
                    array[++i] = String.valueOf(str.charAt(i))
                            .toUpperCase();

                } else {
                    // get the element at the first position, trasform toLowerCase, and put it into array
                    array[i] = String.valueOf(nomeChar)
                            .toLowerCase();
                }

            }

        } catch ( StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Erro na palavra: " + str + "\n " + e);
        } finally {
            word = wordTransdormed(str);
        }

        return word;
    }

    private String wordTransdormed(String word) {

        String[] arrayWord = this.array;

        String wordTransformed = "";
        for (int i = 0; i < arrayWord.length; i++) {

//        System.out.println( " i = "+i +"  tamanho de nomes : "+word.length() );
//                 
            if (i >= word.length()) {
                break;
            } else {
                wordTransformed += array[i];
            }

        }

        return wordTransformed;
    }

    public String toUpperCaseFirstLetter( String str ) {

        String word = null;
        try {

            char nomeChar = 0;

            for (int i = 0; i < str.length(); i++) {

                // get the element at position i
                nomeChar = str.charAt(i);
                if (i == 0) {
                    // get the element at the first position, trasform toUpperCase, and put it into array
                    array[i] = String.valueOf(nomeChar)
                            .toUpperCase();
                } else {
                    // get the element at the first position, trasform toLowerCase, and put it into array
                    array[i] = String.valueOf(nomeChar)
                            .toLowerCase();
                }

            }

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Erro na palavra: " + str + "\n " + e);
        } finally {
            word = wordTransdormed(str);
        }

        return word;

    }

}