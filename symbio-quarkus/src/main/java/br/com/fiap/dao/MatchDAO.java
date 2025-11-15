package br.com.fiap.dao;

import br.com.fiap.beans.ColabSkill;
import br.com.fiap.beans.VagaSkill;
import br.com.fiap.conexoes.ConexaoFactory;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MatchDAO {

    // Busca todas as skills que uma vaga exige
    public List<VagaSkill> buscarSkillsDaVaga(int idVaga) throws SQLException, ClassNotFoundException {
        List<VagaSkill> lista = new ArrayList<>();
        String sql = "SELECT id_vaga, id_skill, nr_peso FROM T_SYM_VAGA_SKILL WHERE id_vaga = ?";

        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVaga);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new VagaSkill(rs.getInt("id_vaga"), rs.getInt("id_skill"), rs.getInt("nr_peso")));
            }
        }
        return lista;
    }

    // Busca todas as skills que um colaborador possui
    public List<ColabSkill> buscarSkillsDoColaborador(int idColaborador) throws SQLException, ClassNotFoundException {
        List<ColabSkill> lista = new ArrayList<>();
        String sql = "SELECT id_colaborador, id_skill, nr_nivel_proficiencia FROM T_SYM_COLAB_SKILL WHERE id_colaborador = ?";

        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idColaborador);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new ColabSkill(rs.getInt("id_colaborador"), rs.getInt("id_skill"), rs.getInt("nr_nivel_proficiencia")));
            }
        }
        return lista;
    }

    // Métodos auxiliares para pegar nome
    public String getNomeSkill(int idSkill) throws SQLException, ClassNotFoundException {
        String nome = "Skill Desconhecida";
        String sql = "SELECT nm_skill FROM T_SYM_SKILL WHERE id_skill = ?";
        try (Connection conn = new ConexaoFactory().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSkill);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) nome = rs.getString("nm_skill");
        }
        return nome;
    }
}