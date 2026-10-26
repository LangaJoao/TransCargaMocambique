package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tad.FilaListaLigada;

/**
 * Gravação e leitura de filas em ficheiros de objectos (.dat).
 */
public class Persistencia {

    private Persistencia() {
    }

    public static <T> void guardar(FilaListaLigada<T> fila, String caminho) throws IOException {
        File ficheiro = new File(caminho);
        File pasta = ficheiro.getParentFile();
        if (pasta != null && !pasta.exists()) {
            pasta.mkdirs();
        }
        ObjectOutputStream saida = null;
        try {
            saida = new ObjectOutputStream(new FileOutputStream(ficheiro));
            saida.writeObject(fila);
        } finally {
            if (saida != null) {
                saida.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> FilaListaLigada<T> carregar(String caminho) {
        File ficheiro = new File(caminho);
        if (!ficheiro.exists()) {
            return new FilaListaLigada<T>();
        }
        ObjectInputStream entrada = null;
        try {
            entrada = new ObjectInputStream(new FileInputStream(ficheiro));
            return (FilaListaLigada<T>) entrada.readObject();
        } catch (Exception e) {
            return new FilaListaLigada<T>();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
