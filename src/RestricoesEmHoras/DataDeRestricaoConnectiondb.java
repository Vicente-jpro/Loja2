/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestricoesEmHoras;

import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class DataDeRestricaoConnectiondb  {

    private DataDeRestricaodb datadb;
    private DataHorasDeRestricao data;
    private DataDeRestricaoCalculos calculos;
    private CurrentDateAndTime dataDeHoje;

    public void salvar(int idPacote, double totalHorasConsumida, String dataInicial, String dataFinal) {

        datadb = new DataDeRestricaodb();
        data = new DataHorasDeRestricao();

        data.setIdPacote(idPacote);
        data.setTotalHorasConsumida(totalHorasConsumida);
        data.setDataInicial(dataInicial);
        data.setDataFinal(dataFinal);

        boolean exiteUmPacoteEscolhido = datadb.ExistenciaDePacoteEscolhido();

        if (exiteUmPacoteEscolhido) {
            JOptionPane.showMessageDialog(null, "Ja exite um pacote escolhido",
                    "PACOTE", JOptionPane.INFORMATION_MESSAGE);
        } else {

            datadb = new DataDeRestricaodb();
            datadb.create(data);

        }

    }

    public boolean getPermicaoParaUsoDaApp() {

        boolean usarApp = true;

        datadb = new DataDeRestricaodb();

        double horasDoPacoteEscolhido = datadb.getHorasParaPermitirUsoDaApp();

        datadb = new DataDeRestricaodb();
        double horasUsada = datadb.getUltimasHoras();
//
//         JOptionPane.showMessageDialog(null, "Horas usadas = " + horasUsada + 
//                 "\n Horas do Pacote = " + horasDoPacoteEscolhido);

        
        if (horasUsada >= horasDoPacoteEscolhido) {
            usarApp = false;
        } else {
            verificarDataParaActualizar();
        }

       
        return usarApp;

    }

    public void verificarDataParaActualizar() {

        String dataInial, dataFinal;

        datadb = new DataDeRestricaodb();

        dataDeHoje = new CurrentDateAndTime();
        dataFinal = dataDeHoje.getCurrentDate();
        dataInial = datadb.getDataInicial();

        // Se a dataInicial nao for igual a dataFinal , segnifica que devo 
        //fazer uma nova actualizacao no banco de dados
        if ( dataInial != dataFinal ) {
//
//            JOptionPane.showMessageDialog(null, "Datas diferentes \n"
//                    + "dataInicial = " + dataFinal + "\n dataFinal = " + dataFinal + "\n");

            calcularHorasUsadas();
        }

    }

    public void calcularHorasUsadas() {

        String dataInicial, dataFinal;

        datadb = new DataDeRestricaodb();
        dataInicial = datadb.getDataInicial();

        dataDeHoje = new CurrentDateAndTime();
        dataFinal = dataDeHoje.getCurrentDate();

        // Introduzir as duas datas para fectuar os calculos das horas
       calculos = new DataDeRestricaoCalculos( dataInicial, dataFinal );
     
        
        datadb = new DataDeRestricaodb();

        // Ultimas horas salva no banco de dados.
        double antigasHorasUtilizadas = datadb.getUltimasHoras();

        // Horas obtida de acordo com a dataInial e dataFinal
        double novasHorasUtilizadas = calculos.calcularHorasUtilizadas();

        double totalHorasConsumida = novasHorasUtilizadas + antigasHorasUtilizadas;

        JOptionPane.showMessageDialog(null, "totalHoras = " + novasHorasUtilizadas + " + " + antigasHorasUtilizadas + "\n"
                + "totalHoras = " + totalHorasConsumida);

        datadb = new DataDeRestricaodb();
        datadb.updateTotalHorasUtilizadas( totalHorasConsumida, dataFinal );

    }

    public void deleteList() {

        datadb = new DataDeRestricaodb();
        datadb.deleteList();

    }

    public void creatList() {

        datadb = new DataDeRestricaodb();
        datadb.creatList();

    }

}
