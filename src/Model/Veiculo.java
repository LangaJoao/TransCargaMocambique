/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author langa
 */
public class Veiculo implements Serializable{

    private String matricula;
    private String marca;
    private String modelo;
    private double capacidadeCarga;
    private Proprietario proprietario;

    public Veiculo(String matricula, String marca, String modelo, double capacidadeCarga, Proprietario proprietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadeCarga = capacidadeCarga;
        this.proprietario = proprietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getTipo() {
        if (this instanceof Camiao) {
            return "Camião";
        }
        if (this instanceof Carrinha) {
            return "Carrinha";
        }
        return "Veículo";
    }

    @Override
    public String toString() {
        return getTipo() + " " + matricula + " (" + marca + " " + modelo + ", "
                + capacidadeCarga + " t) - " + proprietario.getNome();
    }
}
