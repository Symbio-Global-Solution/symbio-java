package br.com.fiap.dao;

import br.com.fiap.beans.Colaborador; // Certifique-se que o bean Colaborador tem dt_admissao (LocalDate) e salario (double)
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {

    public String inserir(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO T_SYM_COLABORADOR (NM_COLABORADOR, DS_EMAIL, DT_ADMISSAO, SALARIO, ID_CARGO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, new String[]{"ID_COLABORADOR"})) {

            stmt.setString(1, colaborador.getNm_colaborador());
            stmt.setString(2, colaborador.getDs_email());
            stmt.setDate(3, Date.valueOf(colaborador.getDt_admissao()));
            stmt.setDouble(4, colaborador.getSalario());
            stmt.setInt(5, colaborador.getId_cargo());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    colaborador.setId_colaborador(rs.getInt(1));
                }
            }
        }
        return "Colaborador cadastrado com sucesso!";
    }

    public String deletar(int idColaborador) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM T_SYM_COLABORADOR WHERE ID_COLABORADOR = ?";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idColaborador);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return "Colaborador com ID " + idColaborador + " não encontrado para deleção.";
            }
        }
        return "Colaborador deletado com sucesso!";
    }

    public String atualizar(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE T_SYM_COLABORADOR SET NM_COLABORADOR = ?, DS_EMAIL = ?, DT_ADMISSAO = ?, SALARIO = ?, ID_CARGO = ? WHERE ID_COLABORADOR = ?";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, colaborador.getNm_colaborador());
            stmt.setString(2, colaborador.getDs_email());
            stmt.setDate(3, Date.valueOf(colaborador.getDt_admissao()));
            stmt.setDouble(4, colaborador.getSalario());
            stmt.setInt(5, colaborador.getId_cargo());
            stmt.setInt(6, colaborador.getId_colaborador());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return "Colaborador com ID " + colaborador.getId_colaborador() + " não encontrado para atualização.";
            }
        }
        return "Colaborador atualizado com sucesso!";
    }

    public List<Colaborador> selecionar() throws SQLException, ClassNotFoundException {
        List<Colaborador> listaColaboradores = new ArrayList<>();
        String sql = "SELECT ID_COLABORADOR, NM_COLABORADOR, DS_EMAIL, DT_ADMISSAO, SALARIO, ID_CARGO FROM T_SYM_COLABORADOR ORDER BY NM_COLABORADOR";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listaColaboradores.add(mapResultSetToColaborador(rs));
            }
        }
        return listaColaboradores;
    }

    public Colaborador buscarPorId(int idColaborador) throws SQLException, ClassNotFoundException {
        Colaborador colaborador = null;
        String sql = "SELECT ID_COLABORADOR, NM_COLABORADOR, DS_EMAIL, DT_ADMISSAO, SALARIO, ID_CARGO FROM T_SYM_COLABORADOR WHERE ID_COLABORADOR = ?";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idColaborador);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    colaborador = mapResultSetToColaborador(rs);
                }
            }
        }
        return colaborador;
    }

    private Colaborador mapResultSetToColaborador(ResultSet rs) throws SQLException {
        Colaborador colaborador = new Colaborador();
        colaborador.setId_colaborador(rs.getInt("ID_COLABORADOR"));
        colaborador.setNm_colaborador(rs.getString("NM_COLABORADOR"));
        colaborador.setDs_email(rs.getString("DS_EMAIL"));

        Date dataAdmissao = rs.getDate("DT_ADMISSAO");
        if (dataAdmissao != null) {
            colaborador.setDt_admissao(dataAdmissao.toLocalDate()); // Converte sql.Date para LocalDate
        }

        colaborador.setSalario(rs.getDouble("SALARIO"));
        colaborador.setId_cargo(rs.getInt("ID_CARGO"));
        return colaborador;
    }
}