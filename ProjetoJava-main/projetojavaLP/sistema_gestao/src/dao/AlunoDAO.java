package dao;

import factory.ConnectionFactory;
import modelo.Aluno;
import modelo.Curso;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (cpf, nome_aluno, email, data_nascimento, cod_curso) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));
            stmt.setInt(5, aluno.getCurso().getId());

            stmt.executeUpdate();
        }
    }

    public List<Aluno> listar() {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM alunos";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        CursoDAO cursoDAO = new CursoDAO(); // para buscar o curso
        while (rs.next()) {
            int id = rs.getInt("cod_aluno");
            String cpf = rs.getString("cpf");
            String nome = rs.getString("nome_aluno");
            String email = rs.getString("email");
            LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
            int cursoId = rs.getInt("cod_curso");

            Curso curso = cursoDAO.buscarPorId(cursoId); // garante o nome do curso

            Aluno aluno = new Aluno(id, cpf, nome, email, dataNascimento, curso);
            alunos.add(aluno);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return alunos;
}

    public int contarAlunosPorCurso(int cursoId) throws SQLException {
        int total = 0;

        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) FROM alunos WHERE cod_curso = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cursoId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            total = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        conn.close();

        return total;
    }

    public Curso buscarPorNome(String nome) {
    Curso curso = null;
    try {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM cursos WHERE nome_curso = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            curso = new Curso();
            curso.setId(rs.getInt("cod_curso"));
            curso.setNome(rs.getString("nome_curso"));
            curso.setLimiteAlunos(rs.getInt("limite_alunos")); // ⚠️ NÃO ESQUEÇA DISSO!
        }
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return curso;
}

    public boolean cadastrarAluno(Aluno aluno) {
    String sqlCount = "SELECT COUNT(*) AS total FROM alunos WHERE cod_curso = ?";
    String sqlLimit = "SELECT limite_alunos FROM cursos WHERE cod_curso = ?";
    String sqlInsert = "INSERT INTO alunos (cpf, nome_aluno, email, data_nascimento, cod_curso) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = ConnectionFactory.getConnection()) {
        
        // Contagem de alunos no curso
        PreparedStatement stmtCount = conn.prepareStatement(sqlCount);
        stmtCount.setInt(1, aluno.getCurso().getId());
        ResultSet rsCount = stmtCount.executeQuery();
        int totalMatriculados = 0;
        if (rsCount.next()) {
            totalMatriculados = rsCount.getInt("total");
        }
        System.out.println("Total alunos matriculados: " + totalMatriculados);  // print

        // Pega o limite do curso
        PreparedStatement stmtLimit = conn.prepareStatement(sqlLimit);
        stmtLimit.setInt(1, aluno.getCurso().getId());
        ResultSet rsLimit = stmtLimit.executeQuery();
        int limite = 0;
        if (rsLimit.next()) {
            limite = rsLimit.getInt("limite_alunos");
        }
        System.out.println("Limite do curso: " + limite);  // print

        // Verifica se pode cadastrar
        if (aluno.getCurso() == null || aluno.getCurso().getId() <= 0) {
            System.out.println("Curso não selecionado! Cadastro abortado.");
            return false;
        }
        if (totalMatriculados >= limite) {
            System.out.println("Curso cheio. Cadastro bloqueado.");
            return false;
        }
        // Cadastra aluno
        PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
        stmtInsert.setString(1, aluno.getCpf());
        stmtInsert.setString(2, aluno.getNome());
        stmtInsert.setString(3, aluno.getEmail());
        stmtInsert.setDate(4, java.sql.Date.valueOf(aluno.getDataNascimento()));
        stmtInsert.setInt(5, aluno.getCurso().getId());
        stmtInsert.executeUpdate();
        System.out.println("Aluno cadastrado com sucesso.");
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE alunos SET cpf = ?, nome_aluno = ?, email = ?, data_nascimento = ?, cod_curso = ? WHERE cod_aluno = ?";
        
        // Obter conexão
        try (Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(aluno.getDataNascimento()));
            stmt.setInt(5, aluno.getCurso().getId());
            stmt.setInt(6, aluno.getId());

            stmt.executeUpdate();
        }
    }
    
    // Excluir aluno
    public void excluir(int id) {
        String sql = "DELETE FROM alunos WHERE cod_aluno = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Aluno> buscarPorCurso(int cursoId) {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM alunos WHERE cod_curso = ?";
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, cursoId);
        try (ResultSet rs = stmt.executeQuery()) {
            CursoDAO cursoDAO = new CursoDAO();
            Curso curso = cursoDAO.buscarPorId(cursoId); // busca uma vez só
            
            while (rs.next()) {
                int id = rs.getInt("cod_aluno");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome_aluno");
                String email = rs.getString("email");
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();
                
                Aluno aluno = new Aluno(id, cpf, nome, email, dataNascimento, curso);
                alunos.add(aluno);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return alunos;
}
}