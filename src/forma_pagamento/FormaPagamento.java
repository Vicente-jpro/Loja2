/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma_pagamento;

/**
 *
 * @author vicente-jpro
 */
public class FormaPagamento {

    private String forma_pagamento;
    private int id_forma_pagamento;

    public FormaPagamento(String forma_pagamento, int id_forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public FormaPagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public FormaPagamento(int id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public int getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(int id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String toString(){
    
        return forma_pagamento;
    }
    
    

}
