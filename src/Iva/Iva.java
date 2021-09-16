/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iva;

/**
 *
 * @author vicente-jpro
 */
public class Iva {
    
        /**
     * @return Valor do IVA = 14%.
     */
    private static final double IVA = 0.14;
    
    //Preço do produto: 1.000.00kz
    private double precoProduto;
    
    
    
    public Iva ( double precoProduto ){
        
        this.precoProduto = precoProduto;
    }
    
    public double getProdutoIva(){
        //Calculando o valor do IVA
        // 1000 * 0.14 = 140
        return precoProduto * IVA; // return 140.00
    }
    
    public double getNovoPrecoComIva(){
    // Calculando o novo preco    
    // 1000 + 140 = 1.140.00
        return (precoProduto * IVA) + precoProduto; // return 1.140.00
    }
    
}
