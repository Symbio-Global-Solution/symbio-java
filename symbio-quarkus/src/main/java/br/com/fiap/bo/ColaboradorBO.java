package br.com.fiap.bo;

import br.com.fiap.beans.Colaborador;
import br.com.fiap.dao.ColaboradorDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ColaboradorBO {

    @Inject
    ColaboradorDAO colaboradorDAO;

    public List<Colaborador> selecionarBo() throws SQLException, ClassNotFoundException {
        return colaboradorDAO.selecionar();
    }

    public Colaborador buscarPorIdBo(int id) throws SQLException, ClassNotFoundException {
        return colaboradorDAO.buscarPorId(id);
    }

    public void inserirBo(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        if (colaborador.getNm_colaborador() == null || colaborador.getNm_colaborador().length() < 3) {
            throw new IllegalArgumentException("Nome do colaborador inválido.");
        }
        colaboradorDAO.inserir(colaborador);
    }

    public void deletarBo(int id) throws SQLException, ClassNotFoundException {
        colaboradorDAO.deletar(id);
    }

    public void atualizarBo(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        colaboradorDAO.atualizar(colaborador);
    }
}