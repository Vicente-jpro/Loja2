/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestricoesEmHoras;

import Pacotes.Pacotes;

/**
 *
 * @author vicente
 */
public class DataHorasDeRestricao extends Pacotes {

    private int idDataDeRestricao;

    private double totalHorasConsumida;

    private String dataInicial,
            dataFinal;

    
    
    
    public DataHorasDeRestricao() {
    }

    public DataHorasDeRestricao( int idDataDeRestricao, double totalHorasConsumida, String dataInicial, String dataFinal) {
        this.idDataDeRestricao = idDataDeRestricao;
        this.totalHorasConsumida = totalHorasConsumida;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public int getIdDataDeRestricao() {
        return idDataDeRestricao;
    }

    public void setIdDataDeRestricao(int idDataDeRestricao) {
        this.idDataDeRestricao = idDataDeRestricao;
    }

 

    public double getTotalHorasConsumida() {
        return totalHorasConsumida;
    }

    public void setTotalHorasConsumida(double totalHorasConsumida) {
        this.totalHorasConsumida = totalHorasConsumida;
    }


    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    

}
