package br.com.fiap.bo;

import br.com.fiap.beans.Colaborador;
import br.com.fiap.dao.ColaboradorDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorBO {

    public ColaboradorDAO colaboradorDAO;

    //Selecionar
    public List<Colaborador> selecionarBo() throws SQLException, ClassNotFoundException {
        colaboradorDAO = new ColaboradorDAO();

        //Regras de negócio
        return colaboradorDAO.selecionar();
    }

    public Colaborador buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        colaboradorDAO = new ColaboradorDAO();

        return colaboradorDAO.buscarPorId(id);
    }

    public void inserirBo(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

        // Regras de negócio
        colaboradorDAO.inserir(colaborador);
    }

    public void deletarBo(int id) throws SQLException, ClassNotFoundException {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

        // Regras de negócio
        colaboradorDAO.deletar(id);
    }

    public void atualizarBo(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

        // Regras de negócio
        colaboradorDAO.atualizar(colaborador);
    }
}