package Service;

import Model.Camiao;
import Model.Carregamento;
import Model.Carrinha;
import Model.Cliente;
import Model.Proprietario;
import Model.Veiculo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tad.FilaListaLigada;

/**
 * Regras de negócio da TransCarga Moçambique.
 * Todas as colecções principais são filas (TAD do grupo).
 */
public class GestaoTransCarga {

    public static final String PASTA_DADOS = "dados";
    public static final String FICH_PROPRIETARIOS = PASTA_DADOS + "/proprietarios.dat";
    public static final String FICH_VEICULOS = PASTA_DADOS + "/veiculos.dat";
    public static final String FICH_CLIENTES = PASTA_DADOS + "/clientes.dat";
    public static final String FICH_CARREGAMENTOS = PASTA_DADOS + "/carregamentos.dat";

    private FilaListaLigada<Proprietario> proprietarios;
    private FilaListaLigada<Veiculo> veiculos;
    private FilaListaLigada<Cliente> clientes;
    private FilaListaLigada<Carregamento> carregamentos;

    public GestaoTransCarga() {
        proprietarios = Persistencia.carregar(FICH_PROPRIETARIOS);
        veiculos = Persistencia.carregar(FICH_VEICULOS);
        clientes = Persistencia.carregar(FICH_CLIENTES);
        carregamentos = Persistencia.carregar(FICH_CARREGAMENTOS);
    }

    public FilaListaLigada<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public FilaListaLigada<Veiculo> getVeiculos() {
        return veiculos;
    }

    public FilaListaLigada<Cliente> getClientes() {
        return clientes;
    }

    public FilaListaLigada<Carregamento> getCarregamentos() {
        return carregamentos;
    }

    public void cadastrarProprietario(String nome, String contacto, String documento) throws IOException {
        validarTexto(nome, "Nome do proprietário");
        validarTexto(contacto, "Contacto do proprietário");
        validarTexto(documento, "Documento de identificação");
        if (buscarProprietario(documento) != null) {
            throw new IllegalArgumentException("Já existe um proprietário com este documento.");
        }
        proprietarios.offer(new Proprietario(nome.trim(), contacto.trim(), documento.trim()));
        Persistencia.guardar(proprietarios, FICH_PROPRIETARIOS);
    }

    public void actualizarProprietario(String documento, String novoNome, String novoContacto) throws IOException {
        Proprietario p = buscarProprietario(documento);
        if (p == null) {
            throw new IllegalArgumentException("Proprietário não encontrado.");
        }
        validarTexto(novoNome, "Nome do proprietário");
        validarTexto(novoContacto, "Contacto do proprietário");
        p.setNome(novoNome.trim());
        p.setContacto(novoContacto.trim());
        Persistencia.guardar(proprietarios, FICH_PROPRIETARIOS);
        Persistencia.guardar(veiculos, FICH_VEICULOS);
    }

    public Proprietario buscarProprietario(String documento) {
        final String doc = documento == null ? "" : documento.trim();
        return proprietarios.buscar(new java.util.function.Predicate<Proprietario>() {
            @Override
            public boolean test(Proprietario p) {
                return p.getDocumentoIdentificacao().equalsIgnoreCase(doc);
            }
        });
    }

    public void cadastrarVeiculo(String tipo, String matricula, String marca, String modelo,
            double capacidade, String documentoProprietario) throws IOException {
        validarTexto(matricula, "Matrícula");
        validarTexto(marca, "Marca");
        validarTexto(modelo, "Modelo");
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade de carga deve ser maior que zero.");
        }
        if (buscarVeiculo(matricula) != null) {
            throw new IllegalArgumentException("Já existe um veículo com esta matrícula.");
        }
        Proprietario dono = buscarProprietario(documentoProprietario);
        if (dono == null) {
            throw new IllegalArgumentException("O veículo tem de estar associado a um proprietário cadastrado.");
        }
        Veiculo veiculo;
        if ("Camião".equalsIgnoreCase(tipo) || "Camiao".equalsIgnoreCase(tipo)) {
            veiculo = new Camiao(matricula.trim(), marca.trim(), modelo.trim(), capacidade, dono);
        } else if ("Carrinha".equalsIgnoreCase(tipo)) {
            veiculo = new Carrinha(matricula.trim(), marca.trim(), modelo.trim(), capacidade, dono);
        } else {
            throw new IllegalArgumentException("Tipo de veículo inválido. Use Camião ou Carrinha.");
        }
        veiculos.offer(veiculo);
        Persistencia.guardar(veiculos, FICH_VEICULOS);
    }

    public void actualizarVeiculo(String matricula, String marca, String modelo, double capacidade) throws IOException {
        Veiculo v = buscarVeiculo(matricula);
        if (v == null) {
            throw new IllegalArgumentException("Veículo não encontrado.");
        }
        validarTexto(marca, "Marca");
        validarTexto(modelo, "Modelo");
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade de carga deve ser maior que zero.");
        }
        v.setMarca(marca.trim());
        v.setModelo(modelo.trim());
        v.setCapacidadeCarga(capacidade);
        Persistencia.guardar(veiculos, FICH_VEICULOS);
    }

    public Veiculo buscarVeiculo(String matricula) {
        final String mat = matricula == null ? "" : matricula.trim();
        return veiculos.buscar(new java.util.function.Predicate<Veiculo>() {
            @Override
            public boolean test(Veiculo v) {
                return v.getMatricula().equalsIgnoreCase(mat);
            }
        });
    }

    public Camiao[] listarCamioesPorCapacidade() {
        List<Camiao> lista = new ArrayList<Camiao>();
        for (Veiculo v : veiculos.paraLista()) {
            if (v instanceof Camiao) {
                lista.add((Camiao) v);
            }
        }
        Camiao[] arr = lista.toArray(new Camiao[lista.size()]);
        ordenarPorCapacidade(arr);
        return arr;
    }

    public Carrinha[] listarCarrinhasPorCapacidade() {
        List<Carrinha> lista = new ArrayList<Carrinha>();
        for (Veiculo v : veiculos.paraLista()) {
            if (v instanceof Carrinha) {
                lista.add((Carrinha) v);
            }
        }
        Carrinha[] arr = lista.toArray(new Carrinha[lista.size()]);
        ordenarPorCapacidade(arr);
        return arr;
    }

    public void cadastrarCliente(String nome, String contacto, String localizacao) throws IOException {
        validarTexto(nome, "Nome do cliente");
        validarTexto(contacto, "Contacto do cliente");
        validarTexto(localizacao, "Localização do cliente");
        final String contactoFinal = contacto.trim();
        Cliente existente = clientes.buscar(new java.util.function.Predicate<Cliente>() {
            @Override
            public boolean test(Cliente c) {
                return c.getContacto().equalsIgnoreCase(contactoFinal);
            }
        });
        if (existente != null) {
            throw new IllegalArgumentException("Já existe um cliente com este contacto.");
        }
        clientes.offer(new Cliente(nome.trim(), contactoFinal, localizacao.trim()));
        Persistencia.guardar(clientes, FICH_CLIENTES);
    }

    public Cliente buscarClientePorContacto(String contacto) {
        final String cont = contacto == null ? "" : contacto.trim();
        return clientes.buscar(new java.util.function.Predicate<Cliente>() {
            @Override
            public boolean test(Cliente c) {
                return c.getContacto().equalsIgnoreCase(cont);
            }
        });
    }

    /**
     * Regista um serviço na fila de carregamentos (ordem de chegada = FIFO).
     * Recusa se a quantidade ultrapassar a capacidade do veículo.
     */
    public void registarCarregamento(String contactoCliente, String matricula,
            double quantidade, String origem, String destino, LocalDate data,
            double valorCobrado) throws IOException {
        Cliente cliente = buscarClientePorContacto(contactoCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado. Cadastre o cliente primeiro.");
        }
        Veiculo veiculo = buscarVeiculo(matricula);
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo não encontrado.");
        }
        validarTexto(origem, "Origem");
        validarTexto(destino, "Destino");
        if (data == null) {
            throw new IllegalArgumentException("A data do carregamento é obrigatória.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de mercadoria deve ser maior que zero.");
        }
        if (valorCobrado < 0) {
            throw new IllegalArgumentException("O valor cobrado não pode ser negativo.");
        }
        if (quantidade > veiculo.getCapacidadeCarga()) {
            throw new IllegalArgumentException(
                    "Quantidade inválida: " + quantidade + " t ultrapassa a capacidade máxima do veículo ("
                    + veiculo.getCapacidadeCarga() + " t).");
        }
        Carregamento carga = new Carregamento(cliente, veiculo, quantidade, origem.trim(),
                destino.trim(), data, valorCobrado);
        carregamentos.offer(carga);
        Persistencia.guardar(carregamentos, FICH_CARREGAMENTOS);
    }

    public List<Carregamento> listarCarregamentos() {
        return carregamentos.paraLista();
    }

    public List<Carregamento> listarCarregamentosPorProprietario(String documento) {
        Proprietario dono = buscarProprietario(documento);
        if (dono == null) {
            throw new IllegalArgumentException("Proprietário não encontrado.");
        }
        List<Carregamento> resultado = new ArrayList<Carregamento>();
        for (Carregamento c : carregamentos.paraLista()) {
            if (c.getVeiculo().getProprietario().getDocumentoIdentificacao()
                    .equalsIgnoreCase(dono.getDocumentoIdentificacao())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public double totalArrecadadoPorVeiculo(String matricula) {
        Veiculo v = buscarVeiculo(matricula);
        if (v == null) {
            throw new IllegalArgumentException("Veículo não encontrado.");
        }
        double total = 0;
        for (Carregamento c : carregamentos.paraLista()) {
            if (c.getVeiculo().getMatricula().equalsIgnoreCase(v.getMatricula())) {
                total += c.getValorCobrado();
            }
        }
        return total;
    }

    private void ordenarPorCapacidade(Veiculo[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getCapacidadeCarga() < arr[menor].getCapacidadeCarga()) {
                    menor = j;
                }
            }
            Veiculo aux = arr[i];
            arr[i] = arr[menor];
            arr[menor] = aux;
        }
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " é obrigatório.");
        }
    }
}
