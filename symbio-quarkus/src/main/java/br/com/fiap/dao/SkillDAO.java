package br.com.fiap.dao;

import br.com.fiap.beans.Skill;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {

    public void inserir(Skill skill) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO T_SYM_SKILL (nm_skill, tp_skill, ds_skill) VALUES (?, ?, ?)";
        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"id_skill"})) {

            stmt.setString(1, skill.getNm_skill());
            stmt.setString(2, skill.getTp_skill());
            stmt.setString(3, skill.getDs_skill());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) skill.setId_skill(rs.getInt(1));
            }
        }
    }

    public List<Skill> selecionar() throws SQLException, ClassNotFoundException {
        List<Skill> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_SYM_SKILL ORDER BY nm_skill";
        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Skill s = new Skill();
                s.setId_skill(rs.getInt("id_skill"));
                s.setNm_skill(rs.getString("nm_skill"));
                s.setTp_skill(rs.getString("tp_skill"));
                s.setDs_skill(rs.getString("ds_skill"));
                lista.add(s);
            }
        }
        return lista;
    }
}