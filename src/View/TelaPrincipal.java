package View;

import Model.Camiao;
import Model.Carregamento;
import Model.Carrinha;
import Model.Cliente;
import Model.Proprietario;
import Model.Veiculo;
import Service.GestaoTransCarga;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends JFrame {

    private final GestaoTransCarga gestao;
    private final DefaultTableModel modeloTabela;

    public TelaPrincipal() {
        this.gestao = new GestaoTransCarga();
        initComponents();
        modeloTabela = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela.setModel(modeloTabela);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        rotuloTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        rotuloTitulo.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        rotuloEstado.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
        rotuloMarca.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(8, 16, 16, 16));
        setSize(1100, 680);
        setLocationRelativeTo(null);
        listarProprietarios();
    }

    /** Componentes editáveis na aba Design do NetBeans. */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        menuCadastroItem0 = new javax.swing.JMenuItem();
        menuCadastroItem0.setText("Proprietário");
        menuCadastroItem0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroItem0ActionPerformed(evt);
            }
        });
        menuCadastroItem1 = new javax.swing.JMenuItem();
        menuCadastroItem1.setText("Veículo");
        menuCadastroItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroItem1ActionPerformed(evt);
            }
        });
        menuCadastroItem2 = new javax.swing.JMenuItem();
        menuCadastroItem2.setText("Cliente");
        menuCadastroItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroItem2ActionPerformed(evt);
            }
        });
        menuCadastroItem3 = new javax.swing.JMenuItem();
        menuCadastroItem3.setText("Carregamento");
        menuCadastroItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroItem3ActionPerformed(evt);
            }
        });
        menuCadastro = new javax.swing.JMenu();
        menuCadastro.setText("Cadastro");
        menuCadastro.add(menuCadastroItem0);
        menuCadastro.add(menuCadastroItem1);
        menuCadastro.add(menuCadastroItem2);
        menuCadastro.add(menuCadastroItem3);
        menuActualizarItem0 = new javax.swing.JMenuItem();
        menuActualizarItem0.setText("Proprietário");
        menuActualizarItem0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActualizarItem0ActionPerformed(evt);
            }
        });
        menuActualizarItem1 = new javax.swing.JMenuItem();
        menuActualizarItem1.setText("Veículo");
        menuActualizarItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActualizarItem1ActionPerformed(evt);
            }
        });
        menuActualizar = new javax.swing.JMenu();
        menuActualizar.setText("Actualizar");
        menuActualizar.add(menuActualizarItem0);
        menuActualizar.add(menuActualizarItem1);
        menuListagensItem0 = new javax.swing.JMenuItem();
        menuListagensItem0.setText("Proprietários");
        menuListagensItem0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagensItem0ActionPerformed(evt);
            }
        });
        menuListagensItem1 = new javax.swing.JMenuItem();
        menuListagensItem1.setText("Camiões (capacidade crescente)");
        menuListagensItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagensItem1ActionPerformed(evt);
            }
        });
        menuListagensItem2 = new javax.swing.JMenuItem();
        menuListagensItem2.setText("Carrinhas (capacidade crescente)");
        menuListagensItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagensItem2ActionPerformed(evt);
            }
        });
        menuListagensItem3 = new javax.swing.JMenuItem();
        menuListagensItem3.setText("Clientes");
        menuListagensItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagensItem3ActionPerformed(evt);
            }
        });
        menuListagensItem4 = new javax.swing.JMenuItem();
        menuListagensItem4.setText("Todos os carregamentos");
        menuListagensItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagensItem4ActionPerformed(evt);
            }
        });
        menuListagensItem5 = new javax.swing.JMenuItem();
        menuListagensItem5.setText("Transportes por proprietário");
        menuListagensItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagensItem5ActionPerformed(evt);
            }
        });
        menuListagensItem6 = new javax.swing.JMenuItem();
        menuListagensItem6.setText("Total arrecadado por veículo");
        menuListagensItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagensItem6ActionPerformed(evt);
            }
        });
        menuListagens = new javax.swing.JMenu();
        menuListagens.setText("Listagens");
        menuListagens.add(menuListagensItem0);
        menuListagens.add(menuListagensItem1);
        menuListagens.add(menuListagensItem2);
        menuListagens.add(menuListagensItem3);
        menuListagens.add(menuListagensItem4);
        menuListagens.add(menuListagensItem5);
        menuListagens.add(menuListagensItem6);
        barraMenu = new javax.swing.JMenuBar();
        barraMenu.add(menuCadastro);
        barraMenu.add(menuActualizar);
        barraMenu.add(menuListagens);
        setJMenuBar(barraMenu);
        rotuloMarca = new javax.swing.JLabel();
        rotuloMarca.setText("<html><b>TransCarga</b><br>Moçambique</html>");
        rotuloMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rotuloMarca.setForeground(java.awt.Color.WHITE);
        rotuloMarca.setPreferredSize(new java.awt.Dimension(250, 100));
        botaoLateral0 = new javax.swing.JButton();
        botaoLateral0.setText("Cadastrar proprietário");
        botaoLateral0.setFocusPainted(false);
        botaoLateral0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral0ActionPerformed(evt);
            }
        });
        botaoLateral1 = new javax.swing.JButton();
        botaoLateral1.setText("Cadastrar veículo");
        botaoLateral1.setFocusPainted(false);
        botaoLateral1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral1ActionPerformed(evt);
            }
        });
        botaoLateral2 = new javax.swing.JButton();
        botaoLateral2.setText("Cadastrar cliente");
        botaoLateral2.setFocusPainted(false);
        botaoLateral2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral2ActionPerformed(evt);
            }
        });
        botaoLateral3 = new javax.swing.JButton();
        botaoLateral3.setText("Registar carregamento");
        botaoLateral3.setFocusPainted(false);
        botaoLateral3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral3ActionPerformed(evt);
            }
        });
        botaoLateral4 = new javax.swing.JButton();
        botaoLateral4.setText("Listar camiões");
        botaoLateral4.setFocusPainted(false);
        botaoLateral4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral4ActionPerformed(evt);
            }
        });
        botaoLateral5 = new javax.swing.JButton();
        botaoLateral5.setText("Listar carrinhas");
        botaoLateral5.setFocusPainted(false);
        botaoLateral5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral5ActionPerformed(evt);
            }
        });
        botaoLateral6 = new javax.swing.JButton();
        botaoLateral6.setText("Carregamentos");
        botaoLateral6.setFocusPainted(false);
        botaoLateral6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral6ActionPerformed(evt);
            }
        });
        botaoLateral7 = new javax.swing.JButton();
        botaoLateral7.setText("Por proprietário");
        botaoLateral7.setFocusPainted(false);
        botaoLateral7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral7ActionPerformed(evt);
            }
        });
        botaoLateral8 = new javax.swing.JButton();
        botaoLateral8.setText("Total por veículo");
        botaoLateral8.setFocusPainted(false);
        botaoLateral8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLateral8ActionPerformed(evt);
            }
        });
        painelBotoes = new javax.swing.JPanel();
        painelBotoes.setOpaque(false);
        painelBotoes.setLayout(new java.awt.GridLayout(0, 1, 8, 8));
        painelBotoes.add(botaoLateral0);
        painelBotoes.add(botaoLateral1);
        painelBotoes.add(botaoLateral2);
        painelBotoes.add(botaoLateral3);
        painelBotoes.add(botaoLateral4);
        painelBotoes.add(botaoLateral5);
        painelBotoes.add(botaoLateral6);
        painelBotoes.add(botaoLateral7);
        painelBotoes.add(botaoLateral8);
        contentorBotoes = new javax.swing.JPanel();
        contentorBotoes.setOpaque(false);
        contentorBotoes.setLayout(new java.awt.BorderLayout());
        contentorBotoes.add(painelBotoes, java.awt.BorderLayout.NORTH);
        painelEsquerdo = new javax.swing.JPanel();
        painelEsquerdo.setBackground(new java.awt.Color(18, 52, 86));
        painelEsquerdo.setPreferredSize(new java.awt.Dimension(250, 0));
        painelEsquerdo.setLayout(new java.awt.BorderLayout());
        painelEsquerdo.add(rotuloMarca, java.awt.BorderLayout.NORTH);
        painelEsquerdo.add(contentorBotoes, java.awt.BorderLayout.CENTER);
        rotuloTitulo = new javax.swing.JLabel();
        rotuloTitulo.setText("Listagem");
        tabela = new javax.swing.JTable();
        tabela.setRowHeight(24);
        rolagemTabela = new javax.swing.JScrollPane();
        rolagemTabela.setViewportView(tabela);
        painelCentro = new javax.swing.JPanel();
        painelCentro.setLayout(new java.awt.BorderLayout());
        painelCentro.add(rotuloTitulo, java.awt.BorderLayout.NORTH);
        painelCentro.add(rolagemTabela, java.awt.BorderLayout.CENTER);
        rotuloEstado = new javax.swing.JLabel();
        rotuloEstado.setText("Pronto. Os dados são gravados em ficheiros de objectos na pasta dados/");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TransCarga Moçambique");
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(painelEsquerdo, java.awt.BorderLayout.WEST);
        getContentPane().add(painelCentro, java.awt.BorderLayout.CENTER);
        getContentPane().add(rotuloEstado, java.awt.BorderLayout.SOUTH);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroItem0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroItem0ActionPerformed
        dialogoProprietario(false);
    }//GEN-LAST:event_menuCadastroItem0ActionPerformed

    private void menuCadastroItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroItem1ActionPerformed
        dialogoVeiculo();
    }//GEN-LAST:event_menuCadastroItem1ActionPerformed

    private void menuCadastroItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroItem2ActionPerformed
        dialogoCliente();
    }//GEN-LAST:event_menuCadastroItem2ActionPerformed

    private void menuCadastroItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroItem3ActionPerformed
        dialogoCarregamento();
    }//GEN-LAST:event_menuCadastroItem3ActionPerformed

    private void menuActualizarItem0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActualizarItem0ActionPerformed
        dialogoProprietario(true);
    }//GEN-LAST:event_menuActualizarItem0ActionPerformed

    private void menuActualizarItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActualizarItem1ActionPerformed
        dialogoActualizarVeiculo();
    }//GEN-LAST:event_menuActualizarItem1ActionPerformed

    private void menuListagensItem0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagensItem0ActionPerformed
        listarProprietarios();
    }//GEN-LAST:event_menuListagensItem0ActionPerformed

    private void menuListagensItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagensItem1ActionPerformed
        listarCamioes();
    }//GEN-LAST:event_menuListagensItem1ActionPerformed

    private void menuListagensItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagensItem2ActionPerformed
        listarCarrinhas();
    }//GEN-LAST:event_menuListagensItem2ActionPerformed

    private void menuListagensItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagensItem3ActionPerformed
        listarClientes();
    }//GEN-LAST:event_menuListagensItem3ActionPerformed

    private void menuListagensItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagensItem4ActionPerformed
        listarCarregamentos();
    }//GEN-LAST:event_menuListagensItem4ActionPerformed

    private void menuListagensItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagensItem5ActionPerformed
        listarPorProprietario();
    }//GEN-LAST:event_menuListagensItem5ActionPerformed

    private void menuListagensItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagensItem6ActionPerformed
        consultarTotalVeiculo();
    }//GEN-LAST:event_menuListagensItem6ActionPerformed

    private void botaoLateral0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral0ActionPerformed
        dialogoProprietario(false);
    }//GEN-LAST:event_botaoLateral0ActionPerformed

    private void botaoLateral1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral1ActionPerformed
        dialogoVeiculo();
    }//GEN-LAST:event_botaoLateral1ActionPerformed

    private void botaoLateral2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral2ActionPerformed
        dialogoCliente();
    }//GEN-LAST:event_botaoLateral2ActionPerformed

    private void botaoLateral3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral3ActionPerformed
        dialogoCarregamento();
    }//GEN-LAST:event_botaoLateral3ActionPerformed

    private void botaoLateral4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral4ActionPerformed
        listarCamioes();
    }//GEN-LAST:event_botaoLateral4ActionPerformed

    private void botaoLateral5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral5ActionPerformed
        listarCarrinhas();
    }//GEN-LAST:event_botaoLateral5ActionPerformed

    private void botaoLateral6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral6ActionPerformed
        listarCarregamentos();
    }//GEN-LAST:event_botaoLateral6ActionPerformed

    private void botaoLateral7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral7ActionPerformed
        listarPorProprietario();
    }//GEN-LAST:event_botaoLateral7ActionPerformed

    private void botaoLateral8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLateral8ActionPerformed
        consultarTotalVeiculo();
    }//GEN-LAST:event_botaoLateral8ActionPerformed

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLateral0;
    private javax.swing.JButton botaoLateral1;
    private javax.swing.JButton botaoLateral2;
    private javax.swing.JButton botaoLateral3;
    private javax.swing.JButton botaoLateral4;
    private javax.swing.JButton botaoLateral5;
    private javax.swing.JButton botaoLateral6;
    private javax.swing.JButton botaoLateral7;
    private javax.swing.JButton botaoLateral8;
    private javax.swing.JLabel rotuloEstado;
    private javax.swing.JLabel rotuloMarca;
    private javax.swing.JLabel rotuloTitulo;
    private javax.swing.JMenu menuActualizar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuListagens;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem menuActualizarItem0;
    private javax.swing.JMenuItem menuActualizarItem1;
    private javax.swing.JMenuItem menuCadastroItem0;
    private javax.swing.JMenuItem menuCadastroItem1;
    private javax.swing.JMenuItem menuCadastroItem2;
    private javax.swing.JMenuItem menuCadastroItem3;
    private javax.swing.JMenuItem menuListagensItem0;
    private javax.swing.JMenuItem menuListagensItem1;
    private javax.swing.JMenuItem menuListagensItem2;
    private javax.swing.JMenuItem menuListagensItem3;
    private javax.swing.JMenuItem menuListagensItem4;
    private javax.swing.JMenuItem menuListagensItem5;
    private javax.swing.JMenuItem menuListagensItem6;
    private javax.swing.JPanel contentorBotoes;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelCentro;
    private javax.swing.JPanel painelEsquerdo;
    private javax.swing.JScrollPane rolagemTabela;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
