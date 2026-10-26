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
public class Cliente implements Serializable{

    private String nome;
    private String contacto;
    private String localizacao;

    public Cliente(String nome, String contacto, String localizacao) {
        this.nome = nome;
        this.contacto = contacto;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getContacto() {
        return contacto;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return nome + " (" + localizacao + ")";
    }
}
