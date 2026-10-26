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
public class Proprietario implements Serializable {

    private String nome;
    private String contacto;
    private String documentoIdentificacao;

    public Proprietario(String nome, String contacto, String documentoIdentificacao) {
        this.nome = nome;
        this.contacto = contacto;
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public String getNome() {
        return nome;
    }

    public String getContacto() {
        return contacto;
    }

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }

    @Override
    public String toString() {
        return nome + " [" + documentoIdentificacao + "]";
    }
}
