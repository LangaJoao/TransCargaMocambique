/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author langa
 */
public class Carregamento {

    private Cliente cliente;
    private Veiculo veiculo;
    private double quantidadeMercadoria;
    private String origem;
    private String destino;
    private LocalDate data;
    private double valorCobrado;

    public Carregamento(Cliente cliente, Veiculo veiculo, double quantidadeMercadoria, String origem, String destino, LocalDate data, double valorCobrado) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.quantidadeMercadoria = quantidadeMercadoria;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.valorCobrado = valorCobrado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getQuantidadeMercadoria() {
        return quantidadeMercadoria;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setQuantidadeMercadoria(double quantidadeMercadoria) {
        this.quantidadeMercadoria = quantidadeMercadoria;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }
    
    

}
