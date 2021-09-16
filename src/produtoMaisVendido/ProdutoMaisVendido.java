/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoMaisVendido;

import compra_historico.CompraHistorico;

/**
 *
 * @author vicente-jpro
 */
public class ProdutoMaisVendido extends CompraHistorico{
    
    private int numero_compras,
            total_item;
    
    public ProdutoMaisVendido(){
    
    }

    public ProdutoMaisVendido(int numero_compras, int total_item) {
        this.numero_compras = numero_compras;
        this.total_item = total_item;
    }
    

    public int getNumero_compras() {
        return numero_compras;
    }

    public void setNumero_compras(int numero_compras) {
        this.numero_compras = numero_compras;
    }

    public int getTotal_item() {
        return total_item;
    }

    public void setTotal_item(int total_item) {
        this.total_item = total_item;
    }
    
    
    
    
    
}
