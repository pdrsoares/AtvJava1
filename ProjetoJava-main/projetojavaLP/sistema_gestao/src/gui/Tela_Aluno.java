package gui;

import gui.ListarAlunosView;
import javax.swing.JOptionPane;
import modelo.Aluno;
import dao.AlunoDAO;
import dao.CursoDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import util.Validador;
import java.util.List;
import modelo.Curso;
import java.sql.SQLException;


public class Tela_Aluno extends javax.swing.JFrame {

    public Tela_Aluno() {
        initComponents();
        
        carregarCursosNoComboBox();
    }
    
    private void carregarCursosNoComboBox() {
    try {
        CursoDAO dao = new CursoDAO(); // Corrigido: era AlunoDAO
        List<String> nomesCursos = dao.buscarNomesCursos(); // Método existe na classe CursoDAO

        jComboBoxCurso.removeAllItems();
        for (String nome : nomesCursos) {
            jComboBoxCurso.addItem(nome);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao carregar cursos: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldDatanasc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCadastrarAluno = new javax.swing.JButton();
        btnListarAlunos = new javax.swing.JButton();
        jComboBoxCurso = new javax.swing.JComboBox<>();
        btnManual = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));
        jPanel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 550));

        jTextFieldCpf.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextFieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCpfActionPerformed(evt);
            }
        });

        jTextFieldNome.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jTextFieldDatanasc.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextFieldDatanasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDatanascActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 10, 13));
        jLabel1.setText("CPF (somento números)");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 10, 13));
        jLabel2.setText("Nome do aluno");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(7, 10, 13));
        jLabel3.setText("E-mail");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(7, 10, 13));
        jLabel4.setText("Data de nascimento:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 10, 13));
        jLabel5.setText("Selecione o curso do aluno:");

        jLabel6.setBackground(new java.awt.Color(7, 10, 13));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setText("Sistema de Gestão de Cursos e Alunos");
        jLabel6.setMaximumSize(new java.awt.Dimension(436, 32));
        jLabel6.setMinimumSize(new java.awt.Dimension(436, 32));

        btnCadastrarAluno.setBackground(new java.awt.Color(0, 127, 95));
        btnCadastrarAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCadastrarAluno.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarAluno.setText("Cadastrar Aluno");
        btnCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAlunoActionPerformed(evt);
            }
        });

        btnListarAlunos.setBackground(new java.awt.Color(0, 53, 102));
        btnListarAlunos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnListarAlunos.setForeground(new java.awt.Color(255, 255, 255));
        btnListarAlunos.setText("Listar Todos Alunos");
        btnListarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAlunosActionPerformed(evt);
            }
        });

        jComboBoxCurso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBoxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursoActionPerformed(evt);
            }
        });

        btnManual.setBackground(new java.awt.Color(0, 53, 102));
        btnManual.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnManual.setForeground(new java.awt.Color(255, 255, 255));
        btnManual.setText("Manual do Projeto");
        btnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel7.setText("Gerencie seus cursos e alunos com facilidade e controle total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldCpf)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jTextFieldDatanasc)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnListarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManual, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDatanasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManual, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCpfActionPerformed

    private void jTextFieldDatanascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDatanascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDatanascActionPerformed

    private void btnCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAlunoActionPerformed
        String nome = jTextFieldNome.getText().trim();
    String email = jTextFieldEmail.getText().trim();
    String cpf = jTextFieldCpf.getText().trim();
    String dataStr = jTextFieldDatanasc.getText().trim();
    String cursoNome = (String) jComboBoxCurso.getSelectedItem();

    // Valida Nome
    if (!Validador.validarNome(nome)) {
        JOptionPane.showMessageDialog(null, "Nome inválido. Mínimo 3 letras e somente letras.");
        return;
    }

    // Valida Email
    if (!Validador.validarEmail(email)) {
        JOptionPane.showMessageDialog(null, "Email inválido. Deve conter '@' e '.'");
        return;
    }

    // Valida CPF
    if (!Validador.validarCpf(cpf)) {
        JOptionPane.showMessageDialog(null, "CPF inválido. Formato esperado: ###.###.###-##");
        return;
    }

    // Valida Data
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataNascimento;
    try {
        dataNascimento = LocalDate.parse(dataStr, formatter);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data de nascimento inválida.");
        return;
    }
    if (!Validador.validarDataNascimento(dataNascimento)) {
        JOptionPane.showMessageDialog(null, "Idade mínima é de 16 anos.");
        return;
    }

    // Valida Curso
    if (cursoNome == null || cursoNome.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione um curso válido.");
        return;
    }

    try {
        CursoDAO cursoDAO = new CursoDAO();
        AlunoDAO alunoDAO = new AlunoDAO();

        // Busca curso pelo nome selecionado no ComboBox
        Curso curso = cursoDAO.buscarPorNome(cursoNome);
        if (curso == null) {
            JOptionPane.showMessageDialog(null, "Curso não encontrado no sistema.");
            return;
        }

        // Validação extra: limite do curso não pode ser zero ou negativo
        if (curso.getLimiteAlunos() <= 0) {
            JOptionPane.showMessageDialog(null, "Curso com limite inválido (zero ou negativo). Por favor, corrija o limite no banco de dados.");
            return;
        }

        // Conta alunos já matriculados
        int alunosMatriculados = alunoDAO.contarAlunosPorCurso(curso.getId());

        if (alunosMatriculados >= curso.getLimiteAlunos()) {
            JOptionPane.showMessageDialog(null, "Curso já atingiu o limite de alunos.");
            return;
        }

        // Criar objeto aluno e cadastrar
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCpf(cpf);
        aluno.setDataNascimento(dataNascimento);
        aluno.setCurso(curso);

        boolean sucesso = alunoDAO.cadastrarAluno(aluno); // ou inserir(aluno), conforme seu método

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno: " + e.getMessage());
    }
    }//GEN-LAST:event_btnCadastrarAlunoActionPerformed

    private void jComboBoxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCursoActionPerformed

    private void btnListarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlunosActionPerformed
        try {
        AlunoDAO dao = new AlunoDAO(); // instancia seu DAO
        List<Aluno> listaAlunos = dao.listar(); // busca os alunos do banco
        ListarAlunosView tela = new ListarAlunosView(); // abre a nova tela
        tela.preencherTabela(listaAlunos); // envia os dados para a jTable
        tela.setVisible(true); // exibe a tela
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao listar alunos: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnListarAlunosActionPerformed

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        InputStream inputStream = getClass().getResourceAsStream("/docs/Manual.pdf");
if (inputStream != null) {
    try {
        // Cria arquivo temporário
        File tempFile = File.createTempFile("Manual", ".pdf");
        tempFile.deleteOnExit();

        // Grava conteúdo do InputStream no arquivo temporário
        Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Abre o arquivo com o programa padrão do sistema
        Desktop.getDesktop().open(tempFile);

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Erro ao abrir o manual: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(this, "Arquivo do manual não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnManualActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Aluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarAluno;
    private javax.swing.JButton btnListarAlunos;
    private javax.swing.JButton btnManual;
    private javax.swing.JComboBox<String> jComboBoxCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldDatanasc;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
