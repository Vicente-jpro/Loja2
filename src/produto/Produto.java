/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import classificacao_produto.ClassificacaoProduto;
import current_user.CurrentUser;
import fornecedor.Fornecedor;
import java.time.LocalDate;
import util.Numerario;

/**
 * @author vicente
 */
public class Produto extends ClassificacaoProduto {

    private String nomeProduto, codigoProduto;
    private LocalDate
            dataFabrico ,
            dataExpiracao ,
            dataRegisto;
    private int idProduto,
            quantidade;
    private double preco,
            iva,
            valorPagarCliente,
            lucroProdutoUnitario;
    private Numerario numerario;
    private Fornecedor fornecedor;

    private CurrentUser currentUser;

    public Produto() {
    }
    
    /**
     *
     * @param codigoProduto Stirng
     */
    public Produto(String codigoProduto){
    this.codigoProduto = codigoProduto;
    
    }
    public Produto(String nomeProduto,  LocalDate dataRegisto,
            int quantidade, String codigoProduto, double preco, double iva, 
            double valorPagarCliente, double lucroProdutoUnitario) {
        this.nomeProduto = nomeProduto;
        this.dataRegisto = dataRegisto;
        this.quantidade = quantidade;
        this.codigoProduto = codigoProduto;
        this.preco = preco;
        this.iva = iva;
        this.valorPagarCliente = valorPagarCliente;
        this.lucroProdutoUnitario = lucroProdutoUnitario;
    }
    
    public Produto(String nomeProduto, LocalDate dataFabrico, LocalDate dataExpiracao, 
           LocalDate dataRegisto, int quantidade, String codigoProduto, double preco, 
           double iva, double valorPagarCliente, double lucroProdutoUnitario) {
        this.nomeProduto = nomeProduto;
        this.dataFabrico = dataFabrico;
        this.dataExpiracao = dataExpiracao;
        this.dataRegisto = dataRegisto;
        this.quantidade = quantidade;
        this.codigoProduto = codigoProduto;
        this.preco = preco;
        this.iva = iva;
        this.valorPagarCliente = valorPagarCliente;
        this.lucroProdutoUnitario = lucroProdutoUnitario;
    }

    public double getLucroProdutoUnitario() {
        return lucroProdutoUnitario;
    }

    public void setLucroProdutoUnitario(double lucroProdutoUnitario) {
        this.lucroProdutoUnitario = lucroProdutoUnitario;
    }

    public Produto(int idProduto) {
        this.idProduto = idProduto;
    }

//    public Produto(String nomePoduto) {
//        this.nomeProduto = nomePoduto;
//    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public LocalDate getDataFabrico() {
        return (LocalDate)dataFabrico;
    }

    public void setDataFabrico(LocalDate dataFabrico) {
        this.dataFabrico = (LocalDate)dataFabrico;
    }

    public LocalDate getDataExpiracao() {
        return (LocalDate)dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = (LocalDate)dataExpiracao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     *
     * @return Preço real sem o IVA
     */
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataRegisto() {
        return (LocalDate)dataRegisto;
    }

    public void setDataRegisto(LocalDate dataRegisto) {
        this.dataRegisto = (LocalDate) dataRegisto;
    }

    /**
     *
     * @return valor do preço unitario com IVA incluido
     */
    public double getValorPagarCliente() {
        return valorPagarCliente;
    }

    public void setValorPagarCliente(double valorPagarCliente) {
        this.valorPagarCliente = valorPagarCliente;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public String toString() {

        return nomeProduto;
    }

    // Display all double value as monetary value $. Ex 123456 going to be 123 456
    public String getIvaDisplay() {
        numerario = null;

        numerario = new Numerario(iva);
        return numerario.getNumberFormated();
    }

    /**
     *
     * @return Preço real sem o IVA
     */
    public String getPrecoDisplay() {
        numerario = null;

        numerario = new Numerario(preco);
        return numerario.getNumberFormated();
    }

    /**
     *
     * @return valor do preço unitario com IVA incluido
     */
    public String getValorPagarClienteDisplay() {
        numerario = null;

        numerario = new Numerario(valorPagarCliente);
        return numerario.getNumberFormated();
    }
    
    
    
    public String getLucroProdutoUnitarioDisplay() {
        numerario = null;

        numerario = new Numerario(lucroProdutoUnitario);
        return numerario.getNumberFormated();
    }

    

}
