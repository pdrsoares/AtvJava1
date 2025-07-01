package gui;

import dao.AlunoDAO;
import dao.CursoDAO;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import gui.TelaConsultaCurso;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import modelo.Aluno;

public class ListarCursosView extends javax.swing.JFrame {


    public ListarCursosView() {
        initComponents();
        configurarTabelaNaoEditavel();
    }
    
    public void preencherTabela(List<Curso> cursos) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (Curso curso : cursos) {
            Object[] linha = {
                curso.getId(),
                curso.getNome(),
                curso.getCargaHoraria(),
                curso.getLimiteAlunos()
            };
            model.addRow(linha);
        }
    }
    
    public void configurarTabelaNaoEditavel() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Código do curso", "Nome", "Carga horária", "Quantidade de Alunos"}
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

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditarView = new javax.swing.JButton();
        btnExcluirView = new javax.swing.JButton();
        btnConsultarCursoView = new javax.swing.JButton();
        btnExportarCursos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(244, 244, 244));

        jTable1.setBackground(new java.awt.Color(19, 31, 38));
        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(217, 217, 217));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Carga Horária", "Qtd Limite Alunos", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEditarView.setBackground(new java.awt.Color(0, 127, 95));
        btnEditarView.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEditarView.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarView.setText("Editar");
        btnEditarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarViewActionPerformed(evt);
            }
        });

        btnExcluirView.setBackground(new java.awt.Color(255, 40, 52));
        btnExcluirView.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnExcluirView.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirView.setText("Excluir");
        btnExcluirView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirViewActionPerformed(evt);
            }
        });

        btnConsultarCursoView.setBackground(new java.awt.Color(0, 53, 102));
        btnConsultarCursoView.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnConsultarCursoView.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarCursoView.setText("Consultar Curso");
        btnConsultarCursoView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCursoViewActionPerformed(evt);
            }
        });

        btnExportarCursos.setBackground(new java.awt.Color(0, 53, 102));
        btnExportarCursos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnExportarCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarCursos.setText("Exportar Cursos");
        btnExportarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarCursosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 10, 13));
        jLabel1.setText("Lista de Cursos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 161, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(297, 297, 297))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEditarView, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirView, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultarCursoView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExportarCursos)
                                .addGap(111, 111, 111)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarView, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarCursoView, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirView, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarViewActionPerformed
        // EDITAR
        int linhaSelecionada = jTable1.getSelectedRow();
    
    if (linhaSelecionada != -1) {
        int id = (int) jTable1.getValueAt(linhaSelecionada, 0);
        String nomeAtual = (String) jTable1.getValueAt(linhaSelecionada, 1);
        int cargaHorariaAtual = (int) jTable1.getValueAt(linhaSelecionada, 2);

        String novoNome = JOptionPane.showInputDialog(this, "Novo nome do curso:", nomeAtual);
        String novaCargaHorariaStr = JOptionPane.showInputDialog(this, "Nova carga horária:", String.valueOf(cargaHorariaAtual));

        if (novoNome != null && novaCargaHorariaStr != null) {
            try {
                int novaCargaHoraria = Integer.parseInt(novaCargaHorariaStr);
                int novaQtdAlunos = Integer.parseInt(JOptionPane.showInputDialog("Nova Qtd de alunos:"));


                Curso curso = new Curso(id, novoNome, novaCargaHoraria, (novaQtdAlunos));
                CursoDAO dao = new CursoDAO();
                dao.atualizar(curso);

                preencherTabela(dao.listar());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Carga horária inválida.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um curso para editar.");
    }
    }//GEN-LAST:event_btnEditarViewActionPerformed

    private void btnExcluirViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirViewActionPerformed
        // EXCLUIR
        int linhaSelecionada = jTable1.getSelectedRow();
    
        if (linhaSelecionada != -1) {
            int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este curso?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                int id = (int) jTable1.getValueAt(linhaSelecionada, 0); // coluna 0 = ID

                CursoDAO dao = new CursoDAO();
                dao.excluir(id);

                // Atualiza a tabela após exclusão
                preencherTabela(dao.listar());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um curso para excluir.");
       }
    }//GEN-LAST:event_btnExcluirViewActionPerformed

    private void btnConsultarCursoViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCursoViewActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow(); // sua JTable de cursos
    if (linhaSelecionada != -1) {
        int cursoId = (int) jTable1.getValueAt(linhaSelecionada, 0); // pega o ID do curso

        try {
            AlunoDAO alunoDAO = new AlunoDAO();
            List<Aluno> alunosDoCurso = alunoDAO.buscarPorCurso(cursoId);

            TelaConsultaCurso tela = new TelaConsultaCurso(); // Sua tela nova
            tela.preencherTabela(alunosDoCurso); // Método que preenche a tabela da nova tela
            tela.setVisible(true);
            this.dispose(); // Fecha a tela atual, se quiser
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar alunos do curso.");
        }

    } else {
        JOptionPane.showMessageDialog(this, "Selecione um curso para consultar.");
    }
    }//GEN-LAST:event_btnConsultarCursoViewActionPerformed

    private void btnExportarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarCursosActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    int opcao = fileChooser.showSaveDialog(this);
    
    if (opcao == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".txt"))) {
            
            // Escreve cabeçalho
            writer.write("ID\tNome\tCarga Horária\tLimite de Alunos");
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
    }//GEN-LAST:event_btnExportarCursosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarCursosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarCursosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarCursosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarCursosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarCursosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarCursoView;
    private javax.swing.JButton btnEditarView;
    private javax.swing.JButton btnExcluirView;
    private javax.swing.JButton btnExportarCursos;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
