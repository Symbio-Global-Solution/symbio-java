package br.com.fiap.dao;

import br.com.fiap.beans.Cargo;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    public String inserir(Cargo cargo) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO T_HC_CARGO (NM_CARGO, DS_CARGO, NIVEL_RISCO_IA) VALUES (?, ?, ?)";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, new String[]{"ID_CARGO"})) {

            stmt.setString(1, cargo.getNm_cargo());
            stmt.setString(2, cargo.getDs_cargo());
            stmt.setString(3, cargo.getNivel_risco_ia());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cargo.setId_cargo(rs.getInt(1));
                }
            }
        }
        return "Cargo cadastrado com sucesso!";
    }

    public String deletar(int idCargo) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM T_HC_CARGO WHERE ID_CARGO = ?";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idCargo);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return "Cargo com ID " + idCargo + " não encontrado para deleção.";
            }
        }
        return "Cargo deletado com sucesso!";
    }

    public String atualizar(Cargo cargo) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE T_HC_CARGO SET NM_CARGO = ?, DS_CARGO = ?, NIVEL_RISCO_IA = ? WHERE ID_CARGO = ?";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cargo.getNm_cargo());
            stmt.setString(2, cargo.getDs_cargo());
            stmt.setString(3, cargo.getNivel_risco_ia());
            stmt.setInt(4, cargo.getId_cargo());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return "Cargo com ID " + cargo.getId_cargo() + " não encontrado para atualização.";
            }
        }
        return "Cargo atualizado com sucesso!";
    }

    public List<Cargo> selecionar() throws SQLException, ClassNotFoundException {
        List<Cargo> listaCargos = new ArrayList<>();
        String sql = "SELECT ID_CARGO, NM_CARGO, DS_CARGO, NIVEL_RISCO_IA FROM T_HC_CARGO ORDER BY NM_CARGO";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listaCargos.add(mapResultSetToCargo(rs));
            }
        }
        return listaCargos;
    }

    public Cargo buscarPorId(int idCargo) throws SQLException, ClassNotFoundException {
        Cargo cargo = null;
        String sql = "SELECT ID_CARGO, NM_CARGO, DS_CARGO, NIVEL_RISCO_IA FROM T_HC_CARGO WHERE ID_CARGO = ?";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idCargo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cargo = mapResultSetToCargo(rs);
                }
            }
        }
        return cargo;
    }

    private Cargo mapResultSetToCargo(ResultSet rs) throws SQLException {
        Cargo cargo = new Cargo();
        cargo.setId_cargo(rs.getInt("ID_CARGO"));
        cargo.setNm_cargo(rs.getString("NM_CARGO"));
        cargo.setDs_cargo(rs.getString("DS_CARGO"));
        cargo.setNivel_risco_ia(rs.getString("NIVEL_RISCO_IA"));
        return cargo;
    }
}