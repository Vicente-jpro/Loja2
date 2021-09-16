/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra_historico;

import compra.Compra;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author vicente-jpro
 */
public class CompraHistorico extends Compra {


    
    public CompraHistorico() {
       
    }
    
    public CompraHistorico(int idCompra, double valorUnitario, double subTotal, double valorTotal, 
            double trocoCliente, LocalDate dataCompra, LocalTime hora) {
        super(idCompra, valorUnitario, subTotal, valorTotal, trocoCliente, dataCompra, hora);
    }


    
    
    
}
