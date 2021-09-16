/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author vicente
 */
public class Cliente {

    private int idCliente;
    private String morada, nomeCliente = "Não definido";

    public Cliente() {

    }

    public Cliente (int idCliente){
    
        this.idCliente = idCliente;
    }
    
    
    public Cliente(int idCliente, String nomeCliente, String morada) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        setMoradaDefault(morada);
    }

    public Cliente(String nomeCliente, String morada) {
     
        this.nomeCliente = nomeCliente;
        setMoradaDefault(morada);
    }

    public Cliente(String nomeCliente) {
       this.nomeCliente = nomeCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
       setMoradaDefault(morada);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    
    public String toString (){
        return nomeCliente;
    }
    
    private void setMoradaDefault(String morada){
     if (morada == "Morada" || morada.isEmpty() )
            this.morada = "Nenhuma";
        else
            this.morada = morada;
    }
    
    
    
}
