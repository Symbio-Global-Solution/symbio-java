package br.com.fiap.bo;

import br.com.fiap.beans.Skill;
import br.com.fiap.dao.SkillDAO;
import jakarta.enterprise.context.ApplicationScoped;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class SkillBO {
    private SkillDAO skillDAO = new SkillDAO();

    public List<Skill> listar() throws SQLException, ClassNotFoundException {
        return skillDAO.selecionar();
    }

    public void cadastrar(Skill skill) throws SQLException, ClassNotFoundException {
        skillDAO.inserir(skill);
    }
}