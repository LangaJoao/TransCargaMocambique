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
public abstract class FilaListaLigada<T> implements Fila<T>, Serializable {

    private Celula<T> primeiro;
    private Celula<T> ultimo;
    private int totalDeElementos;

    public FilaListaLigada() {
        primeiro = null;
        ultimo = null;
        totalDeElementos = 0;
    }

    @Override
    public int size() {
        return totalDeElementos;
    }

    @Override
    public boolean isEmpty() {
        return totalDeElementos == 0;
    }

    @Override
    public void offer(T elemento) {
       
    }

    @Override
    public T poll() {
       
        return null;
    }

}
