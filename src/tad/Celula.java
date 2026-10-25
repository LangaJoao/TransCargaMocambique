/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad;

import java.io.Serializable;

/**
 *
 * @author langa
 */
public class Celula<T> implements Serializable {

    private T elemento;
    private Celula<T> proxima;

    public Celula(T elemento) {
        this.elemento = elemento;
        this.proxima = null;
    }

    public T getElemento() {
        return elemento;
    }

    public Celula<T> getProxima() {
        return proxima;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setProxima(Celula<T> proxima) {
        this.proxima = proxima;
    }

}
