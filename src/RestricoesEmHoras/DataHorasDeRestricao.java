/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestricoesEmHoras;

import Pacotes.Pacotes;
import java.time.LocalDateTime;

/**
 *
 * @author vicente
 */
public class DataHorasDeRestricao extends Pacotes {

    private int idDataDeRestricao;

    private double totalHorasConsumida;

    private LocalDateTime dataInicial,
            dataFinal;

    
    
    
    public DataHorasDeRestricao() {
    }

    public DataHorasDeRestricao( int idDataDeRestricao, double totalHorasConsumida, LocalDateTime dataInicial, LocalDateTime dataFinal) {
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


    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    

}
