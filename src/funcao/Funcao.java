/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcao;


/**
 *
 * @author vicente-jpro
 */
public class Funcao {
    
    private String  descricao ;
    private int id_funcao; 

    public Funcao(){
    this.descricao = "Não definida";
    }
    public Funcao(String descricao, int id_funcao) {
        this.descricao = descricao;
        this.id_funcao = id_funcao;
    }

    
    public Funcao( int id_funcao) {
        this.id_funcao = id_funcao;
    }
    
    
    public Funcao(String descricao) {
        this.descricao = descricao;
       
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_funcao() {
        return id_funcao;
    }

    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
    }
    
    @Override
    public String toString() {
    return descricao;
    }
    
}
