package gui;

import dao.AlunoDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Aluno;
import modelo.Curso;
import dao.CursoDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import javax.swing.JFileChooser;

public class ListarAlunosView extends javax.swing.JFrame {


    public ListarAlunosView() {
        initComponents();
        configurarTabelaNaoEditavel();
    }
    
    public void preencherTabela(List<Aluno> alunos) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (Aluno aluno : alunos) {
            Object[] linha = {
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                aluno.getCurso() != null ? aluno.getCurso().getNome() : "N/A"
            };
            model.addRow(linha);
        }
    }

    public void configurarTabelaNaoEditavel() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Código do aluno", "Nome", "E-mail", "CPF", "Data de nascimento", "Curso"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede edição das células
            }
        };

        jTable1.setModel(model);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditarAluno = new javax.swing.JButton();
        btnExcluirAluno = new javax.swing.JButton();
        btnExportarAlunos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(244, 244, 244));

        jTable1.setBackground(new java.awt.Color(19, 31, 38));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(217, 217, 217));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cpf", "Nome", "Email", "Data de Nascimento", "Curso"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEditarAluno.setBackground(new java.awt.Color(0, 127, 95));
        btnEditarAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEditarAluno.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarAluno.setText("Editar");
        btnEditarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAlunoActionPerformed(evt);
            }
        });

        btnExcluirAluno.setBackground(new java.awt.Color(255, 40, 52));
        btnExcluirAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnExcluirAluno.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirAluno.setText("Excluir");
        btnExcluirAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAlunoActionPerformed(evt);
            }
        });

        btnExportarAlunos.setBackground(new java.awt.Color(0, 53, 102));
        btnExportarAlunos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnExportarAlunos.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarAlunos.setText("Exportar Alunos");
        btnExportarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarAlunosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 10, 13));
        jLabel1.setText("Lista de Alunos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnExcluirAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btnExportarAlunos))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAlunoActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();
if (linhaSelecionada != -1) {
    try {
        int id = Integer.parseInt(jTable1.getValueAt(linhaSelecionada, 0).toString());
        String nomeAtual = (String) jTable1.getValueAt(linhaSelecionada, 1);
        String emailAtual = (String) jTable1.getValueAt(linhaSelecionada, 2);
        String cpfAtual = (String) jTable1.getValueAt(linhaSelecionada, 3);
        String dataStr = jTable1.getValueAt(linhaSelecionada, 4).toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataStr, formatter);

        // Pega o nome do curso da tabela
        String nomeCurso = jTable1.getValueAt(linhaSelecionada, 5).toString();

        // Busca o curso pelo nome usando CursoDAO
        CursoDAO cursoDAO = new CursoDAO();
        Curso curso = cursoDAO.buscarPorNome(nomeCurso);

        if (curso == null) {
            JOptionPane.showMessageDialog(this, "Curso não encontrado: " + nomeCurso);
            return;
        }

        // Coleta novos dados
        String novoNome = JOptionPane.showInputDialog(this, "Novo nome:", nomeAtual);
        if (novoNome == null || novoNome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome não pode ficar vazio. Operação cancelada.");
            return;
        }

        String novoCpf = JOptionPane.showInputDialog(this, "Novo CPF:", cpfAtual);
        if (novoCpf == null || novoCpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CPF não pode ficar vazio. Operação cancelada.");
            return;
        }

        String novoEmail = JOptionPane.showInputDialog(this, "Novo email:", emailAtual);
        if (novoEmail == null || novoEmail.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email não pode ficar vazio. Operação cancelada.");
            return;
        }

        // Pergunta nova data de nascimento
        String novaDataStr = JOptionPane.showInputDialog(this, "Nova data de nascimento (dd/MM/yyyy):", dataStr);
        LocalDate novaDataNascimento = dataNascimento;
        if (novaDataStr != null && !novaDataStr.trim().isEmpty()) {
            try {
                novaDataNascimento = LocalDate.parse(novaDataStr, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Data inválida, mantendo a original.");
            }
        }

        // Não altera o curso, mantém o atual

        // Cria objeto aluno atualizado
        Aluno alunoAtualizado = new Aluno(id, novoCpf, novoNome, novoEmail, novaDataNascimento, curso);

        // Atualiza no banco
        AlunoDAO dao = new AlunoDAO();
        dao.atualizar(alunoAtualizado);

        // Recarrega tabela
        preencherTabela(dao.listar());

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao buscar curso: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar aluno: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(this, "Selecione um aluno para editar.");
}
    }//GEN-LAST:event_btnEditarAlunoActionPerformed

    private void btnExcluirAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAlunoActionPerformed
        // EXCLUIR
        int linhaSelecionada = jTable1.getSelectedRow(); // sua JTable de alunos

    if (linhaSelecionada != -1) {
        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            int id = (int) jTable1.getValueAt(linhaSelecionada, 0); // Supondo que a coluna 0 é o ID do aluno

            AlunoDAO dao = new AlunoDAO();
            dao.excluir(id);

            // Atualiza a tabela de alunos
            preencherTabela(dao.listar());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um aluno para excluir.");
    }
    }//GEN-LAST:event_btnExcluirAlunoActionPerformed

    private void btnExportarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarAlunosActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    int opcao = fileChooser.showSaveDialog(this);

    if (opcao == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".txt"))) {
            
            // Escreve cabeçalho
            writer.write("ID\tNome\tEmail\tCPF\tData de Nascimento\tCurso");
            writer.newLine();

            // Escreve dados da tabela
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String linha = "";
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    linha += jTable1.getValueAt(i, j) + "\t";
                }
                writer.write(linha.trim());
                writer.newLine();
            }

            JOptionPane.showMessageDialog(this, "Arquivo exportado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao exportar: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnExportarAlunosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarAlunosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarAluno;
    private javax.swing.JButton btnExcluirAluno;
    private javax.swing.JButton btnExportarAlunos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
