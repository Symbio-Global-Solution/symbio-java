package br.com.fiap.dao;

import br.com.fiap.beans.Vaga;
import br.com.fiap.conexoes.ConexaoFactory;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VagaDAO {

    public void inserir(Vaga vaga) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO T_SYM_VAGA (ds_titulo, dt_abertura, st_vaga) VALUES (?, ?, ?)";
        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"id_vaga"})) {

            stmt.setString(1, vaga.getDs_titulo());
            stmt.setDate(2, Date.valueOf(vaga.getDt_abertura()));
            stmt.setString(3, vaga.getSt_vaga());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) vaga.setId_vaga(rs.getInt(1));
            }
        }
    }

    public List<Vaga> selecionar() throws SQLException, ClassNotFoundException {
        List<Vaga> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_SYM_VAGA ORDER BY dt_abertura DESC";
        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Vaga v = new Vaga();
                v.setId_vaga(rs.getInt("id_vaga"));
                v.setDs_titulo(rs.getString("ds_titulo"));
                v.setSt_vaga(rs.getString("st_vaga"));
                Date dt = rs.getDate("dt_abertura");
                if (dt != null) v.setDt_abertura(dt.toLocalDate());
                lista.add(v);
            }
        }
        return lista;
    }
}