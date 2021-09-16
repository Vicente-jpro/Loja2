/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestricoesEmHoras;

/**
 *
 * @author vicente
 */
public interface GetData {
    
     int getDia( String data );    
     int getMes( String data );
     int getAno( String data );
     /*
     * getDataAnterior() pega a data antiga salvada no banco de dados
     * e retorna esta data
     **/
}
