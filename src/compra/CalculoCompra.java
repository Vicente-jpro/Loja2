/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;

/**
 *
 * @author vicente-jpro
 */
public class CalculoCompra {
    
    private double valorUnitario, 
                    subTotal, 
                    valorTotal;
    
    private int quantidade;
    
    
    public CalculoCompra (double valorUnitario, int quantidade){
    
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    
    }
    
    
    public double getSubtotal (){
    
    this.subTotal = valorUnitario * quantidade;
    
    return subTotal;
    
    }
    
    
}
