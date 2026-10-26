package tad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Fila (FIFO) implementada com lista ligada simples e generics.
 * Inserção no fim (offer) e remoção no início (poll).
 */
public class FilaListaLigada<T> implements Fila<T>, Serializable {

    private static final long serialVersionUID = 1L;

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

    /**
     * Coloca o elemento no fim da fila (FIFO).
     */
    @Override
    public void offer(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("Não é permitido inserir elemento nulo na fila.");
        }
        Celula<T> nova = new Celula<T>(elemento);
        if (isEmpty()) {
            primeiro = nova;
            ultimo = nova;
        } else {
            ultimo.setProxima(nova);
            ultimo = nova;
        }
        totalDeElementos++;
    }

    /**
     * Remove e devolve o elemento da frente da fila. Devolve null se estiver vazia.
     */
    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T elemento = primeiro.getElemento();
        primeiro = primeiro.getProxima();
        if (primeiro == null) {
            ultimo = null;
        }
        totalDeElementos--;
        return elemento;
    }

    /**
     * Consulta a frente da fila sem remover.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return primeiro.getElemento();
    }

    /**
     * Percorre a lista ligada da frente para o fim até encontrar o primeiro
     * elemento que satisfaz o critério. Não altera a ordem da fila.
     */
    public T buscar(Predicate<T> criterio) {
        Celula<T> atual = primeiro;
        while (atual != null) {
            T elemento = atual.getElemento();
            if (criterio.test(elemento)) {
                return elemento;
            }
            atual = atual.getProxima();
        }
        return null;
    }

    /**
     * Cópia dos elementos pela ordem da fila (do mais antigo para o mais recente).
     * Usada nas listagens e na ordenação, sem destruir a fila com poll().
     */
    public List<T> paraLista() {
        List<T> copia = new ArrayList<T>();
        Celula<T> atual = primeiro;
        while (atual != null) {
            copia.add(atual.getElemento());
            atual = atual.getProxima();
        }
        return copia;
    }
}
