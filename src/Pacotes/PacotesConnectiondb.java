/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacotes;

import RestricoesEmHoras.CurrentDateAndTime;
import RestricoesEmHoras.DataDeRestricaoConnectiondb;
import RestricoesEmHoras.DataDeRestricaodb;
import RestricoesEmHoras.DataHorasDeRestricao;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class PacotesConnectiondb {

    private Pacotesdb pacotesdb;
    private Pacotes pacotes;
    
    private DataDeRestricaodb dataDeRestricaodb;
    private DataDeRestricaoConnectiondb dataDeRestricaoConnectiondb;
    private DataHorasDeRestricao dataHorasDeRestricao;
    
    private CurrentDateAndTime date;
    

    public int getIdPacoteEscolhido( String nomeDoPacote ) {

        pacotesdb = new Pacotesdb();
        pacotes = new Pacotes();

        pacotes.setDescricao( nomeDoPacote );

      
        
        int idPacote = pacotesdb.getIdPacoteEscolhido( pacotes );

        inserirPacoteNaDataHoraDeRestricaotb ( idPacote );
       
        return idPacote;

    }
    
    // Estado de inicializacao do uso do pacote 
    //( O pacote e logo definido na tabela de DataHorasDeRestricao)
    public void inserirPacoteNaDataHoraDeRestricaotb( int idPacoteEscolhido ){
    
        String dataInicial, dataFinal;
        double totalHorasConsumida = 0.0;
        
        date = new CurrentDateAndTime();
        
        // datas de hoje 
        dataInicial = date.getCurrentDate();
        dataFinal = date.getCurrentDate();
        
        
        dataDeRestricaoConnectiondb = new DataDeRestricaoConnectiondb();
        
        dataDeRestricaoConnectiondb.salvar( idPacoteEscolhido, totalHorasConsumida, dataInicial, dataFinal );
        
//        
//          JOptionPane.showMessageDialog(null, "\n idPacote = "+idPacoteEscolhido );
    
    }
    

}
