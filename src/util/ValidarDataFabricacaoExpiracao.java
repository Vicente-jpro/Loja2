/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *@return This class verify two dates fabricacao e expiracão
 * . Se a data inserida é valida ou não para 
 * cadastrar um determinado produto. 
 * @author vicente-jpro
 */
public class ValidarDataFabricacaoExpiracao {

    //yyyy-MM-dd
    private String fabricacao; // 2022-01-10
    private String expiracao;// 2024-01-10

    public ValidarDataFabricacaoExpiracao(String dataFabricacao, String dataExpiracao) {
        this.fabricacao = dataFabricacao;
        this.expiracao = dataExpiracao;
    }

    public boolean getValidacao() {

        
        String mensagem = null;

        boolean dataValida = false;
        try {
        
        
        int anoFabricacao,
                mesFabricacao;

        anoFabricacao = Integer.parseInt(fabricacao.substring(0, 4));
        mesFabricacao = Integer.parseInt(fabricacao.substring(5, 7));

//        System.out.println("Mês de Expiracao = "+mesExpiracao+"\n Mês de Fabricacao = "+mesFabricacao);
//        
//System.out.println("Ano = "+anoFabricacao);
//System.out.println("mes = "+mesFabricacao);
        int anoExpiracao,
                mesExpiracao;

        anoExpiracao = Integer.parseInt(expiracao.substring(0, 4));
        mesExpiracao = Integer.parseInt(expiracao.substring(5, 7));
     
        
        
        // 2020-01-12 Fabricacao
        // 2020-04-12 Expiracao

        if ( anoExpiracao > anoFabricacao )
            dataValida = true;
        else
            if ( mesExpiracao > mesFabricacao )
                dataValida = true;
        
            
        
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return dataValida;
            
    }

}
