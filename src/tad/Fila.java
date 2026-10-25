/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad;

/**
 *
 * @author langa
 * @param <T>
 */
public interface Fila<T> {

    int size();

    boolean isEmpty();

    void offer(T elemento);

    T poll();

}
