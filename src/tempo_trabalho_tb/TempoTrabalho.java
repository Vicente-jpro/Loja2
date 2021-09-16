/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempo_trabalho_tb;

import usuario.Usuario;

/**
 *
 * @author vicente-jpro
 */
public class TempoTrabalho extends Usuario{
    
   private int	id_tempo;
	private String data_hora_entrada ,
	data_hora_saida;
//
//        private String data_hora_entrada ,
//	data_hora_saida;
    public TempoTrabalho( String data_hora_entrada, String data_hora_saida) {
        
        if (data_hora_saida == null)
            this.data_hora_saida = "2021-01-01 01:01:01";// data não definida
        else
            this.data_hora_saida = data_hora_saida;
        
        this.data_hora_entrada = data_hora_entrada;
        
    }

    public TempoTrabalho(int id_tempo, String data_hora_entrada, String data_hora_saida) {
        this.id_tempo = id_tempo;
        this.data_hora_entrada = data_hora_entrada;
        this.data_hora_saida = data_hora_saida;
    }

    public TempoTrabalho(int idTempo) {
        this.id_tempo = idTempo;
    }
    
    public TempoTrabalho(){
    
    // Empty constructor
    }
    
    

    public int getId_tempo() {
        return id_tempo;
    }

    public void setId_tempo(int id_tempo) {
        this.id_tempo = id_tempo;
    }

    public String getData_hora_entrada() {
        return data_hora_entrada;
    }

    public void setData_hora_entrada(String data_hora_entrada) {
        this.data_hora_entrada = data_hora_entrada;
    }

    public String getData_hora_saida() {
        return data_hora_saida;
    }

    public void setData_hora_saida(String data_hora_saida) {
        this.data_hora_saida = data_hora_saida;
    }
    
    
    
	
    
}
