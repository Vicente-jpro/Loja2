/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previlegio;

/**
 *
 * @author vicente-jpro
 */
public class Previlegio {
    
      private String descricao;
    private int id_previlegio;

    public Previlegio(String descricao, int id_previlegio) {
        this.descricao = descricao;
        this.id_previlegio = id_previlegio;
    }

    
    
    public Previlegio( int id_previlegio) {
       
        this.id_previlegio = id_previlegio;
    }

    public Previlegio(String descricao) {
        this.descricao = descricao;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_previlegio() {
        return id_previlegio;
    }

    public void setId_previlegio(int id_previlegio) {
        this.id_previlegio = id_previlegio;
    }
  
    public String toString(){
    return descricao;
    }
    
    
}
