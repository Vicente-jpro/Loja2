/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import Pessoa.Pessoa;
import funcao.Funcao;
import previlegio.Previlegio;

/**
 *
 * @author vicente
 */
public class Usuario extends Pessoa {

    private String password;

    private int idUsuario;
    private Funcao funcao;
    private Previlegio previlegio;
    public Usuario (){  }
    
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Usuario ( String nomeUsuario ){
    
        super(nomeUsuario);
    }

    public Usuario(String nomeUsuario, String password) {
        super(nomeUsuario);
        this.password = password;

    }
    


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Previlegio getPrevilegio() {
        return previlegio;
    }

    public void setPrevilegio(Previlegio previlegio) {
        this.previlegio = previlegio;
    }

    
    
}
