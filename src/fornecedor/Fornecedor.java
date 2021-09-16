/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fornecedor;

import Endereco.Endereco;

/**
 *
 * @author vicente
 */
public class Fornecedor extends Endereco {

    private int idFornecedor;
    private String nomeFornecedor;

    public Fornecedor(){
    
    }
    
    public Fornecedor(int idFornecedor) {

        this.idFornecedor = idFornecedor;

    }

    public Fornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    
    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    
    public String toString(){
        return nomeFornecedor;
    }
    
    
}
