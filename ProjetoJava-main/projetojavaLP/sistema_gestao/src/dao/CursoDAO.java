package dao;

import factory.ConnectionFactory;
import modelo.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    // Inserir curso no banco de dados
    public boolean inserir(Curso curso) {
        String sql = "INSERT INTO cursos (nome_curso, carga_horaria, limite_alunos) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.setInt(3, curso.getLimiteAlunos());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos os cursos do banco
    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM cursos";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso(
                    rs.getInt("cod_curso"),
                    rs.getString("nome_curso"),
                    rs.getInt("carga_horaria"),
                    rs.getInt("limite_alunos")
                );
                cursos.add(curso);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    // Formatar lista de cursos como texto
    public String formatarCursosParaExibicao(List<Curso> cursos) {
        if (cursos.isEmpty()) {
            return "Nenhum curso encontrado.";
        }

        StringBuilder sb = new StringBuilder("Cursos cadastrados:\n\n");
        for (Curso curso : cursos) {
            sb.append("ID: ").append(curso.getId())
              .append("\nNome: ").append(curso.getNome())
              .append("\nCarga Horária: ").append(curso.getCargaHoraria()).append("h")
              .append("\nLimite de Alunos: ").append(curso.getLimiteAlunos())
              .append("\n------------------------\n");
        }

        return sb.toString();
    }

    // Excluir curso
    public void excluir(int id) {
        String sql = "DELETE FROM cursos WHERE cod_curso = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualizar curso
    public void atualizar(Curso curso) {
        String sql = "UPDATE cursos SET nome_curso = ?, carga_horaria = ?, limite_alunos = ? WHERE cod_curso = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.setInt(3, curso.getLimiteAlunos());
            stmt.setInt(4, curso.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar curso por nome
    public Curso buscarPorNome(String nome) throws SQLException {
    Curso curso = null;
    String sql = "SELECT * FROM cursos WHERE nome_curso = ?";
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            curso = new Curso();
            curso.setId(rs.getInt("cod_curso"));
            curso.setNome(rs.getString("nome_curso"));
            curso.setCargaHoraria(rs.getInt("carga_horaria"));      // <- adiciona isso
            curso.setLimiteAlunos(rs.getInt("limite_alunos"));      // <- e isso também
        }
    }
    return curso;
}

    // Verifica se ainda é possível cadastrar alunos no curso
    public boolean podeCadastrarAluno(int idCurso) throws SQLException {
        int alunosMatriculados = 0;
        int limiteAlunos = 0;

        try (Connection conn = ConnectionFactory.getConnection()) {
            // Conta os alunos já matriculados nesse curso
            String sqlAlunos = "SELECT COUNT(*) FROM alunos WHERE cod_curso = ?";
            try (PreparedStatement stmtAlunos = conn.prepareStatement(sqlAlunos)) {
                stmtAlunos.setInt(1, idCurso);
                ResultSet rsAlunos = stmtAlunos.executeQuery();
                if (rsAlunos.next()) {
                    alunosMatriculados = rsAlunos.getInt(1);
                }
                rsAlunos.close();
            }

            // Consulta o limite do curso
            String sqlLimite = "SELECT limite_alunos FROM cursos WHERE cod_curso = ?";
            try (PreparedStatement stmtLimite = conn.prepareStatement(sqlLimite)) {
                stmtLimite.setInt(1, idCurso);
                ResultSet rsLimite = stmtLimite.executeQuery();
                if (rsLimite.next()) {
                    limiteAlunos = rsLimite.getInt("limite_alunos");
                }
                rsLimite.close();
            }
        }

        return alunosMatriculados < limiteAlunos;
    }
    
    public Curso buscarPorId(int id) throws SQLException {
    Curso curso = null;
    String sql = "SELECT * FROM cursos WHERE cod_curso = ?";
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            curso = new Curso();
            curso.setId(rs.getInt("cod_curso"));
            curso.setNome(rs.getString("nome_curso"));
            curso.setCargaHoraria(rs.getInt("carga_horaria"));
            curso.setLimiteAlunos(rs.getInt("limite_alunos"));
        }
    }
    return curso;
}
    // Buscar apenas os nomes dos cursos (usado para ComboBox)
    public List<String> buscarNomesCursos() {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome_curso FROM cursos";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nomes.add(rs.getString("nome_curso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomes;
    }
}