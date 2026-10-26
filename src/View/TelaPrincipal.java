package View;

import Model.Camiao;
import Model.Carregamento;
import Model.Carrinha;
import Model.Cliente;
import Model.Proprietario;
import Model.Veiculo;
import Service.GestaoTransCarga;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends JFrame {

    private final GestaoTransCarga gestao;
    private final DefaultTableModel modeloTabela;
    private final JTable tabela;
    private final JLabel rotuloTitulo;
    private final JLabel rotuloEstado;

    public TelaPrincipal() {
        super("TransCarga Moçambique");
        this.gestao = new GestaoTransCarga();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 680);
        setLocationRelativeTo(null);

        modeloTabela = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela = new JTable(modeloTabela);
        tabela.setRowHeight(24);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

        rotuloTitulo = new JLabel("Listagem", SwingConstants.LEFT);
        rotuloTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        rotuloTitulo.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        rotuloEstado = new JLabel("Pronto. Os dados são gravados em ficheiros de objectos na pasta dados/");
        rotuloEstado.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));

        setJMenuBar(criarMenu());
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(criarPainelEsquerdo(), BorderLayout.WEST);
        getContentPane().add(criarPainelCentro(), BorderLayout.CENTER);
        getContentPane().add(rotuloEstado, BorderLayout.SOUTH);

        listarProprietarios();
    }

    private JMenuBar criarMenu() {
        JMenuBar barra = new JMenuBar();

        JMenu cadastro = new JMenu("Cadastro");
        cadastro.add(item("Proprietário", new Runnable() {
            public void run() {
                dialogoProprietario(false);
            }
        }));
        cadastro.add(item("Veículo", new Runnable() {
            public void run() {
                dialogoVeiculo();
            }
        }));
        cadastro.add(item("Cliente", new Runnable() {
            public void run() {
                dialogoCliente();
            }
        }));
        cadastro.add(item("Carregamento", new Runnable() {
            public void run() {
                dialogoCarregamento();
            }
        }));

        JMenu actualizar = new JMenu("Actualizar");
        actualizar.add(item("Proprietário", new Runnable() {
            public void run() {
                dialogoProprietario(true);
            }
        }));
        actualizar.add(item("Veículo", new Runnable() {
            public void run() {
                dialogoActualizarVeiculo();
            }
        }));

        JMenu listagens = new JMenu("Listagens");
        listagens.add(item("Proprietários", new Runnable() {
            public void run() {
                listarProprietarios();
            }
        }));
        listagens.add(item("Camiões (capacidade crescente)", new Runnable() {
            public void run() {
                listarCamioes();
            }
        }));
        listagens.add(item("Carrinhas (capacidade crescente)", new Runnable() {
            public void run() {
                listarCarrinhas();
            }
        }));
        listagens.add(item("Clientes", new Runnable() {
            public void run() {
                listarClientes();
            }
        }));
        listagens.add(item("Todos os carregamentos", new Runnable() {
            public void run() {
                listarCarregamentos();
            }
        }));
        listagens.add(item("Transportes por proprietário", new Runnable() {
            public void run() {
                listarPorProprietario();
            }
        }));
        listagens.add(item("Total arrecadado por veículo", new Runnable() {
            public void run() {
                consultarTotalVeiculo();
            }
        }));

        barra.add(cadastro);
        barra.add(actualizar);
        barra.add(listagens);
        return barra;
    }

    private JMenuItem item(String texto, final Runnable accao) {
        JMenuItem mi = new JMenuItem(texto);
        mi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                accao.run();
            }
        });
        return mi;
    }

    private JPanel criarPainelEsquerdo() {
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(250, 0));
        painel.setBackground(new Color(18, 52, 86));
        painel.setLayout(new BorderLayout());

        JLabel marca = new JLabel("<html><b>TransCarga</b><br>Moçambique</html>", SwingConstants.CENTER);
        marca.setForeground(Color.WHITE);
        marca.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        marca.setBorder(BorderFactory.createEmptyBorder(24, 12, 24, 12));
        painel.add(marca, BorderLayout.NORTH);

        JPanel botoes = new JPanel(new GridLayout(0, 1, 8, 8));
        botoes.setOpaque(false);
        botoes.setBorder(BorderFactory.createEmptyBorder(8, 16, 16, 16));
        botoes.add(botaoLateral("Cadastrar proprietário", new Runnable() {
            public void run() {
                dialogoProprietario(false);
            }
        }));
        botoes.add(botaoLateral("Cadastrar veículo", new Runnable() {
            public void run() {
                dialogoVeiculo();
            }
        }));
        botoes.add(botaoLateral("Cadastrar cliente", new Runnable() {
            public void run() {
                dialogoCliente();
            }
        }));
        botoes.add(botaoLateral("Registar carregamento", new Runnable() {
            public void run() {
                dialogoCarregamento();
            }
        }));
        botoes.add(botaoLateral("Listar camiões", new Runnable() {
            public void run() {
                listarCamioes();
            }
        }));
        botoes.add(botaoLateral("Listar carrinhas", new Runnable() {
            public void run() {
                listarCarrinhas();
            }
        }));
        botoes.add(botaoLateral("Carregamentos", new Runnable() {
            public void run() {
                listarCarregamentos();
            }
        }));
        botoes.add(botaoLateral("Por proprietário", new Runnable() {
            public void run() {
                listarPorProprietario();
            }
        }));
        botoes.add(botaoLateral("Total por veículo", new Runnable() {
            public void run() {
                consultarTotalVeiculo();
            }
        }));

        JPanel contentor = new JPanel(new BorderLayout());
        contentor.setOpaque(false);
        contentor.add(botoes, BorderLayout.NORTH);
        painel.add(contentor, BorderLayout.CENTER);
        return painel;
    }

    private JButton botaoLateral(String texto, final Runnable accao) {
        JButton b = new JButton(texto);
        b.setFocusPainted(false);
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                accao.run();
            }
        });
        return b;
    }

    private JPanel criarPainelCentro() {
        JPanel centro = new JPanel(new BorderLayout());
        centro.add(rotuloTitulo, BorderLayout.NORTH);
        centro.add(new JScrollPane(tabela), BorderLayout.CENTER);
        return centro;
    }

    private void dialogoProprietario(final boolean actualizar) {
        JTextField nome = new JTextField();
        JTextField contacto = new JTextField();
        JTextField documento = new JTextField();
        if (actualizar) {
            String doc = JOptionPane.showInputDialog(this, "Documento do proprietário a actualizar:");
            if (doc == null || doc.trim().isEmpty()) {
                return;
            }
            Proprietario p = gestao.buscarProprietario(doc);
            if (p == null) {
                erro("Proprietário não encontrado.");
                return;
            }
            nome.setText(p.getNome());
            contacto.setText(p.getContacto());
            documento.setText(p.getDocumentoIdentificacao());
            documento.setEditable(false);
        }
        Object[] campos = {
            "Nome:", nome,
            "Contacto:", contacto,
            "Documento de identificação:", documento
        };
        int op = JOptionPane.showConfirmDialog(this, campos,
                actualizar ? "Actualizar proprietário" : "Cadastrar proprietário",
                JOptionPane.OK_CANCEL_OPTION);
        if (op != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            if (actualizar) {
                gestao.actualizarProprietario(documento.getText(), nome.getText(), contacto.getText());
                sucesso("Proprietário actualizado e gravado no ficheiro de objectos.");
            } else {
                gestao.cadastrarProprietario(nome.getText(), contacto.getText(), documento.getText());
                sucesso("Proprietário cadastrado e gravado em dados/proprietarios.dat");
            }
            listarProprietarios();
        } catch (Exception ex) {
            erro(ex.getMessage());
        }
    }

    private void dialogoVeiculo() {
        if (gestao.getProprietarios().isEmpty()) {
            erro("Cadastre primeiro um proprietário. Cada veículo pertence a um único dono.");
            return;
        }
        JComboBox<String> tipo = new JComboBox<String>(new String[]{"Camião", "Carrinha"});
        JTextField matricula = new JTextField();
        JTextField marca = new JTextField();
        JTextField modelo = new JTextField();
        JTextField capacidade = new JTextField();
        JComboBox<Proprietario> donos = new JComboBox<Proprietario>();
        for (Proprietario p : gestao.getProprietarios().paraLista()) {
            donos.addItem(p);
        }
        Object[] campos = {
            "Tipo:", tipo,
            "Matrícula:", matricula,
            "Marca:", marca,
            "Modelo:", modelo,
            "Capacidade (toneladas):", capacidade,
            "Proprietário:", donos
        };
        int op = JOptionPane.showConfirmDialog(this, campos, "Cadastrar veículo",
                JOptionPane.OK_CANCEL_OPTION);
        if (op != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            Proprietario escolhido = (Proprietario) donos.getSelectedItem();
            gestao.cadastrarVeiculo((String) tipo.getSelectedItem(), matricula.getText(),
                    marca.getText(), modelo.getText(),
                    Double.parseDouble(capacidade.getText().replace(",", ".")),
                    escolhido.getDocumentoIdentificacao());
            sucesso("Veículo associado ao proprietário e gravado em dados/veiculos.dat");
            if ("Camião".equals(tipo.getSelectedItem())) {
                listarCamioes();
            } else {
                listarCarrinhas();
            }
        } catch (NumberFormatException ex) {
            erro("Capacidade inválida. Use um número (ex.: 2.5).");
        } catch (Exception ex) {
            erro(ex.getMessage());
        }
    }

    private void dialogoActualizarVeiculo() {
        String mat = JOptionPane.showInputDialog(this, "Matrícula do veículo a actualizar:");
        if (mat == null || mat.trim().isEmpty()) {
            return;
        }
        Veiculo v = gestao.buscarVeiculo(mat);
        if (v == null) {
            erro("Veículo não encontrado.");
            return;
        }
        JTextField marca = new JTextField(v.getMarca());
        JTextField modelo = new JTextField(v.getModelo());
        JTextField capacidade = new JTextField(String.valueOf(v.getCapacidadeCarga()));
        Object[] campos = {
            "Marca:", marca,
            "Modelo:", modelo,
            "Capacidade (toneladas):", capacidade
        };
        int op = JOptionPane.showConfirmDialog(this, campos, "Actualizar veículo " + v.getMatricula(),
                JOptionPane.OK_CANCEL_OPTION);
        if (op != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            gestao.actualizarVeiculo(v.getMatricula(), marca.getText(), modelo.getText(),
                    Double.parseDouble(capacidade.getText().replace(",", ".")));
            sucesso("Veículo actualizado e gravado no ficheiro de objectos.");
            if (v instanceof Camiao) {
                listarCamioes();
            } else {
                listarCarrinhas();
            }
        } catch (NumberFormatException ex) {
            erro("Capacidade inválida.");
        } catch (Exception ex) {
            erro(ex.getMessage());
        }
    }

    private void dialogoCliente() {
        JTextField nome = new JTextField();
        JTextField contacto = new JTextField();
        JTextField localizacao = new JTextField();
        Object[] campos = {
            "Nome:", nome,
            "Contacto:", contacto,
            "Localização:", localizacao
        };
        int op = JOptionPane.showConfirmDialog(this, campos, "Cadastrar cliente",
                JOptionPane.OK_CANCEL_OPTION);
        if (op != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            gestao.cadastrarCliente(nome.getText(), contacto.getText(), localizacao.getText());
            sucesso("Cliente cadastrado e gravado em dados/clientes.dat");
            listarClientes();
        } catch (Exception ex) {
            erro(ex.getMessage());
        }
    }

    private void dialogoCarregamento() {
        if (gestao.getClientes().isEmpty() || gestao.getVeiculos().isEmpty()) {
            erro("É necessário ter pelo menos um cliente e um veículo cadastrados.");
            return;
        }
        JComboBox<Cliente> comboCliente = new JComboBox<Cliente>();
        for (Cliente c : gestao.getClientes().paraLista()) {
            comboCliente.addItem(c);
        }
        JComboBox<Veiculo> comboVeiculo = new JComboBox<Veiculo>();
        for (Veiculo v : gestao.getVeiculos().paraLista()) {
            comboVeiculo.addItem(v);
        }
        JTextField quantidade = new JTextField();
        JTextField origem = new JTextField();
        JTextField destino = new JTextField();
        JTextField data = new JTextField(LocalDate.now().toString());
        JTextField valor = new JTextField();
        Object[] campos = {
            "Cliente:", comboCliente,
            "Veículo (e respectivo proprietário):", comboVeiculo,
            "Quantidade (toneladas):", quantidade,
            "Origem:", origem,
            "Destino:", destino,
            "Data (AAAA-MM-DD):", data,
            "Valor cobrado (MT):", valor
        };
        int op = JOptionPane.showConfirmDialog(this, campos, "Registar carregamento",
                JOptionPane.OK_CANCEL_OPTION);
        if (op != JOptionPane.OK_OPTION) {
            return;
        }
        try {
            Cliente cliente = (Cliente) comboCliente.getSelectedItem();
            Veiculo veiculo = (Veiculo) comboVeiculo.getSelectedItem();
            gestao.registarCarregamento(
                    cliente.getContacto(),
                    veiculo.getMatricula(),
                    Double.parseDouble(quantidade.getText().replace(",", ".")),
                    origem.getText(),
                    destino.getText(),
                    LocalDate.parse(data.getText().trim()),
                    Double.parseDouble(valor.getText().replace(",", ".")));
            sucesso("Carregamento validado e colocado na fila (FIFO), gravado em dados/carregamentos.dat");
            listarCarregamentos();
        } catch (NumberFormatException ex) {
            erro("Quantidade ou valor inválido.");
        } catch (DateTimeParseException ex) {
            erro("Data inválida. Use o formato AAAA-MM-DD.");
        } catch (Exception ex) {
            erro(ex.getMessage());
        }
    }

    private void listarProprietarios() {
        modeloTabela.setColumnIdentifiers(new Object[]{"Nome", "Contacto", "Documento"});
        modeloTabela.setRowCount(0);
        for (Proprietario p : gestao.getProprietarios().paraLista()) {
            modeloTabela.addRow(new Object[]{p.getNome(), p.getContacto(), p.getDocumentoIdentificacao()});
        }
        rotuloTitulo.setText("Proprietários / transportadores  (" + gestao.getProprietarios().size() + ")");
    }

    private void listarClientes() {
        modeloTabela.setColumnIdentifiers(new Object[]{"Nome", "Contacto", "Localização"});
        modeloTabela.setRowCount(0);
        for (Cliente c : gestao.getClientes().paraLista()) {
            modeloTabela.addRow(new Object[]{c.getNome(), c.getContacto(), c.getLocalizacao()});
        }
        rotuloTitulo.setText("Clientes  (" + gestao.getClientes().size() + ")");
    }

    private void listarCamioes() {
        Camiao[] lista = gestao.listarCamioesPorCapacidade();
        preencherVeiculos(lista, "Camiões por ordem crescente da capacidade");
    }

    private void listarCarrinhas() {
        Carrinha[] lista = gestao.listarCarrinhasPorCapacidade();
        preencherVeiculos(lista, "Carrinhas por ordem crescente da capacidade");
    }

    private void preencherVeiculos(Veiculo[] lista, String titulo) {
        modeloTabela.setColumnIdentifiers(new Object[]{
            "Matrícula", "Marca", "Modelo", "Capacidade (t)", "Proprietário", "Documento"
        });
        modeloTabela.setRowCount(0);
        for (int i = 0; i < lista.length; i++) {
            Veiculo v = lista[i];
            modeloTabela.addRow(new Object[]{
                v.getMatricula(), v.getMarca(), v.getModelo(), v.getCapacidadeCarga(),
                v.getProprietario().getNome(), v.getProprietario().getDocumentoIdentificacao()
            });
        }
        rotuloTitulo.setText(titulo + "  (" + lista.length + ")");
    }

    private void listarCarregamentos() {
        preencherCarregamentos(gestao.listarCarregamentos(), "Carregamentos / transportes realizados");
    }

    private void listarPorProprietario() {
        if (gestao.getProprietarios().isEmpty()) {
            erro("Não há proprietários cadastrados.");
            return;
        }
        JComboBox<Proprietario> combo = new JComboBox<Proprietario>();
        for (Proprietario p : gestao.getProprietarios().paraLista()) {
            combo.addItem(p);
        }
        int op = JOptionPane.showConfirmDialog(this, combo, "Escolha o proprietário",
                JOptionPane.OK_CANCEL_OPTION);
        if (op != JOptionPane.OK_OPTION) {
            return;
        }
        Proprietario p = (Proprietario) combo.getSelectedItem();
        try {
            List<Carregamento> lista = gestao.listarCarregamentosPorProprietario(p.getDocumentoIdentificacao());
            preencherCarregamentos(lista, "Transportes do proprietário " + p.getNome());
        } catch (Exception ex) {
            erro(ex.getMessage());
        }
    }

    private void preencherCarregamentos(List<Carregamento> lista, String titulo) {
        modeloTabela.setColumnIdentifiers(new Object[]{
            "Data", "Cliente", "Veículo", "Proprietário", "Qtd (t)", "Origem", "Destino", "Valor (MT)"
        });
        modeloTabela.setRowCount(0);
        for (Carregamento c : lista) {
            modeloTabela.addRow(new Object[]{
                c.getData(),
                c.getCliente().getNome(),
                c.getVeiculo().getMatricula() + " (" + c.getVeiculo().getTipo() + ")",
                c.getVeiculo().getProprietario().getNome(),
                c.getQuantidadeMercadoria(),
                c.getOrigem(),
                c.getDestino(),
                c.getValorCobrado()
            });
        }
        rotuloTitulo.setText(titulo + "  (" + lista.size() + ")");
    }

    private void consultarTotalVeiculo() {
        if (gestao.getVeiculos().isEmpty()) {
            erro("Não há veículos cadastrados.");
            return;
        }
        JComboBox<Veiculo> combo = new JComboBox<Veiculo>();
        for (Veiculo v : gestao.getVeiculos().paraLista()) {
            combo.addItem(v);
        }
        int op = JOptionPane.showConfirmDialog(this, combo, "Escolha o veículo",
                JOptionPane.OK_CANCEL_OPTION);
        if (op != JOptionPane.OK_OPTION) {
            return;
        }
        Veiculo v = (Veiculo) combo.getSelectedItem();
        try {
            double total = gestao.totalArrecadadoPorVeiculo(v.getMatricula());
            JOptionPane.showMessageDialog(this,
                    "Veículo: " + v.getMatricula() + "\nProprietário: " + v.getProprietario().getNome()
                    + "\nTotal arrecadado: " + total + " MT",
                    "Total por veículo", JOptionPane.INFORMATION_MESSAGE);
            rotuloEstado.setText("Total do veículo " + v.getMatricula() + ": " + total + " MT");
        } catch (Exception ex) {
            erro(ex.getMessage());
        }
    }

    private void sucesso(String msg) {
        rotuloEstado.setText(msg);
        JOptionPane.showMessageDialog(this, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void erro(String msg) {
        rotuloEstado.setText("Erro: " + msg);
        JOptionPane.showMessageDialog(this, msg, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
