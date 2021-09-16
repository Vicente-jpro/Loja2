/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import Endereco.Endereco;

/**
 *
 * @author vicente
 */
public class Pessoa extends Endereco {

    private String nome;
    private int idPessoa;


    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(int idPessoa ) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
