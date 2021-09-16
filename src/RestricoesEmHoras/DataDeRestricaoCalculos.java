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
public class DataDeRestricaoCalculos implements GetData {

    private String[] pacote = {
        " 1mes -> 30dias ",
        " 1tremestre -> 3meses ",
        " 1semestre -> 6meses ",
        " 1ano -> 12meses "
    };

    private String dataInicial;
    private String dataFinal;

    /*
    *TOTAL DAS HORAS ÚTEIS PARA CADA PACOTE
    *UNIDADE EM HORAS
    Esses são os valores salvos no banco de dados
    private final double UM_MES =  744.0; 
    private final double UM_TRIMESTRE = 2232.0; 
    private final double UM_SEMESTRE = 4464.0;
    private final double UM_ANO = 8928.0; 
     */
    /**
     *
     * @param dataInicial recebe o ano-mes-dia ( YYYY-MM-DD ) do primeiro dia do
     * uso da aplicação
     * @param dataFinal recebe o ano-mes-dia ( YYYY-MM-DD ) do último dia do uso
     * da aplicação
     */
    public DataDeRestricaoCalculos(String dataInicial, String dataFinal) {

        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;

    }

    /*
    * Método responsavel por calcular 
    * o intervalo dos dias de uso
    * Ex: di = 2020-02-29; df = 2020-03-30 ;
    *  30dia - 29dia = 1dia;
    * return 1dia ;
     */
    public int calcularDiasUteis() {

        int dia = 0;

        dia = getDia(this.dataFinal) - getDia(this.dataInicial);

        // Se o dia for negativo, então converte para positivo
        if (dia < 0) {
            dia *= (-1);
        }

        return dia;
    }

    /*
    * Método responsavel por calcular
    * o intervalo dos meses de uso
    * Ex: di = 2020-02-29; df = 2020-03-30 ;
    *  3mes - 2mes = 1mes;
    * return 1mes ;
     */
    public int calcularMeses() {

        int mes = 0;

        mes = getMes(this.dataFinal) - getMes(this.dataInicial);

        // Se o mes for negativo, então converte para positivo
        if (mes < 0) {
            mes *= (-1);
        }

        return mes;

    }

    /*
    * Método responsavel por calcular
    * as hora total do uso da aplicação
    *  1mês = ( 1mes x 30dia ) + intervaloDosDiasDeUso = horasTotalUtilizada
     */
    public double calcularHorasUtilizadas() {

        int totalDias = 0;
        double horasTotalUtilizada = 0.0;

        totalDias = (calcularMeses() * 30) + calcularDiasUteis();

        horasTotalUtilizada = 24 * totalDias;

        return horasTotalUtilizada;

    }

    @Override
    public int getDia(String data) {

        int dia = Integer.parseInt(data.substring(8));
        return dia;
    }

    @Override
    public int getMes(String data) {

        //JOptionPane.showMessageDialog(null, "data obtida :" + data + "\n data retirada:_" + data.substring(5, 7).length()+"_");

        int mes = Integer.parseInt(data.substring(5, 7));  // data.substring(5, 7)
        
        return mes;
    }

    @Override
    public int getAno(String data) {

        int ano = Integer.parseInt(data.substring(0, 4));

        return ano;

    }

    public void showPackages() {

        System.out.println("Pacotes desponiveis");

        for (int i = 0; i < pacote.length; i++) {
            System.out.println(pacote[i]);
        }

    }

    public void escolherPacote() {

        try {

            String escolha = JOptionPane.showInputDialog(null,
                    "Qual pacote deseja? \n\n"
                    + " \t 1º - " + pacote[0] + "\n"
                    + " \t 2º - " + pacote[1] + "\n"
                    + " \t 3º - " + pacote[2] + "\n"
                    + " \t 4º - " + pacote[3] + "\n\n",
                    "Escolher Pacote", JOptionPane.QUESTION_MESSAGE);

            int opcao = Integer.parseInt(escolha);

            double horas = 0.0;

            switch (opcao) {

                case 1:
                    horas = 744.0;
                    break;
                case 2:
                    horas = 2232.0;
                    break;
                case 3:
                    horas = 4464.0;
                    break;
                case 4:
                    horas = 8928.0;
                    break;
                default:
                    int escoha = JOptionPane.showConfirmDialog(null, " Este pacote não existe.\n"
                            + "Queres escolher outro pacote?",
                            " ERRO ", JOptionPane.ERROR_MESSAGE);
                    if (escoha == 0) {
                        escolherPacote();
                    }

            }

            int mes = getMes(this.dataInicial);

            if (validarPedidoDoPacote(mes)) {
                JOptionPane.showMessageDialog(null, "Este pacote não esta desponivel para este ano"
                        + "Escolhe o 3º Pacote",
                        " ERRO ", JOptionPane.ERROR_MESSAGE);

                escolherPacote();

            }

        } catch (NumberFormatException e) {

            int opcao = JOptionPane.showConfirmDialog(
                    null, " Número invalido.\n"
                    + "Queres digitar novamente? ", " ERRO ", JOptionPane.ERROR_MESSAGE);
            if (opcao == 0) {
                escolherPacote();
            }
        }

    }

    // Verifica se o estamos nos últimos meses
    private boolean validarPedidoDoPacote(int mesActual) {
        // Se o mês actual for igual ao mês de Outubro.
        return mesActual >= 10;
    }

}
