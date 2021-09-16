package Pacotes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vicente
 */
public class Pacotes {

    
    /*
        Descricao          Duração em horas 
    	1 mês               744
	3 meses             2232
	6 meses             4464
	1 ano               8928
    */
    
    
    private int idPacote;
    private String descricao;
    private double duracaoEmHoras;

    public Pacotes(int idPacote, String descricao, double duracaoEmHoras) {
        this.idPacote = idPacote;
        this.descricao = descricao;
        this.duracaoEmHoras = duracaoEmHoras;
    }

    public Pacotes() {
    }

    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDuracaoEmHoras() {
        return duracaoEmHoras;
    }

    public void setDuracaoEmHoras(double duracaoEmHoras) {
        this.duracaoEmHoras = duracaoEmHoras;
    }
    
    public String toString(){
        return descricao;
    }

}
