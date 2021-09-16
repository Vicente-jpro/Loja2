/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;

import cliente.Cliente;
import forma_pagamento.FormaPagamento;
import java.time.LocalDate;
import java.time.LocalTime;
import org.exolab.castor.types.Time;
import produto.Produto;
import util.Numerario;

/**
 *
 * @author vicente-jpro
 */
public class Compra extends Produto {

    private int idCompra;
    private Cliente cliente;
    private double valorUnitario,
            subTotal,
            valorTotal,
            trocoCliente,
            lucro; // lucro -> corresponde ao lucro de venda de produtos
    private LocalTime  hora;
    private LocalDate dataCompra;
    private FormaPagamento formaPagamento;
    private Numerario numerario;

    public Compra() {

        // Inicialize all attributs
        this(0, 0.0, 0.0, 0.0, 0.0, null, null);
        this.cliente = null;
        this.formaPagamento = null;

    }

    public Compra(LocalTime hora) {

        this.hora = hora;
    }

    public Compra(int idCompra) {

        this.idCompra = idCompra;

    }

    public Compra(int idCompra, double valorUnitario,
            double subTotal, double valorTotal, double trocoCliente,
            LocalDate dataCompra, LocalTime hora) {
        this.idCompra = idCompra;

        this.valorUnitario = valorUnitario;
        this.subTotal = subTotal;
        this.valorTotal = valorTotal;
        this.trocoCliente = trocoCliente;
        this.dataCompra = dataCompra;
        this.hora = hora;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getTrocoCliente() {
        return trocoCliente;
    }

    public void setTrocoCliente(double trocoCliente) {
        this.trocoCliente = trocoCliente;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Numerario getNumerario() {
        return numerario;
    }

    public void setNumerario(Numerario numerario) {
        this.numerario = numerario;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

   

    public void setValorTotalDisplay(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String toString() {
        return String.valueOf(dataCompra);
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // Display all double value as monetary value $. Ex 123456 going to be 123 456
    public String getLucroDisplay() {
        numerario = null;
        
        numerario = new Numerario(lucro);
        return numerario.getNumberFormated();

    }

    public String getTrocoClienteDisplay() {
        
        numerario = null;
        
        numerario = new Numerario(trocoCliente);
        return numerario.getNumberFormated();
    }

    public String getValorUnitarioDisplay() {
        numerario = null;
        
        numerario = new Numerario(valorUnitario);
        return numerario.getNumberFormated();
    }

    public String getSubTotalDisplay() {
        numerario = null;
        
        numerario = new Numerario(subTotal);
        return numerario.getNumberFormated();
    }

    public String getValorTotalDisplay() {
        numerario = null;
        
        numerario = new Numerario(valorTotal);
        return numerario.getNumberFormated();
    }

}
