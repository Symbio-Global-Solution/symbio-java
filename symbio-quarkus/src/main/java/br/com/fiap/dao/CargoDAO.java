package br.com.fiap.dao;

import br.com.fiap.beans.Cargo;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    public void inserir(Cargo cargo) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO T_SYM_CARGO (nm_cargo, ds_cargo, nivel_risco_ia) VALUES (?, ?, ?)";
        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"id_cargo"})) {

            stmt.setString(1, cargo.getNm_cargo());
            stmt.setString(2, cargo.getDs_cargo());
            stmt.setString(3, cargo.getNivel_risco_ia());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) cargo.setId_cargo(rs.getInt(1));
            }
        }
    }

    public List<Cargo> selecionar() throws SQLException, ClassNotFoundException {
        List<Cargo> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_SYM_CARGO ORDER BY nm_cargo";
        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cargo c = new Cargo();
                c.setId_cargo(rs.getInt("id_cargo"));
                c.setNm_cargo(rs.getString("nm_cargo"));
                c.setDs_cargo(rs.getString("ds_cargo"));
                c.setNivel_risco_ia(rs.getString("nivel_risco_ia"));
                lista.add(c);
            }
        }
        return lista;
    }
}