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

public class TelaConsultaCurso extends javax.swing.JFrame {

    public TelaConsultaCurso() {
        initComponents();
        configurarTabelaNaoEditavel();
    }

    public void configurarTabelaNaoEditavel() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Código do aluno", "Nome", "-Email", "CPF", "Data de nascimento", "Curso"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede edição das células
            }
        };

        jTable1.setModel(model);
    }
    
    public void preencherTabela(List<Aluno> alunos) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); // substitua jTable1 pelo nome da sua JTable se for diferente
    model.setRowCount(0); // limpa a tabela

    for (Aluno aluno : alunos) {
        model.addRow(new Object[]{
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getCpf(),
            aluno.getDataNascimento(),
            aluno.getCurso().getNome()
        });
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnExportarTxt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(19, 31, 38));
        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(217, 217, 217));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CPF", "Nome", "Email", "Data de Nascimento", "Curso"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 10, 13));
        jLabel1.setText("Alunos do curso selecionado");

        btnExportarTxt.setBackground(new java.awt.Color(0, 53, 102));
        btnExportarTxt.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnExportarTxt.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarTxt.setText("Exportar Tabela");
        btnExportarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnExportarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarTxtActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    int opcao = fileChooser.showSaveDialog(this);
    
    if (opcao == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".txt"))) {
            
            // Escreve cabeçalho no padrão
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
    }//GEN-LAST:event_btnExportarTxtActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
