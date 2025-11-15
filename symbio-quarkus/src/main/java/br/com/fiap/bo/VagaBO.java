package br.com.fiap.bo;

import br.com.fiap.beans.Vaga;
import br.com.fiap.dao.VagaDAO;
import jakarta.enterprise.context.ApplicationScoped;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class VagaBO {
    private VagaDAO vagaDAO = new VagaDAO();

    public List<Vaga> listar() throws SQLException, ClassNotFoundException {
        return vagaDAO.selecionar();
    }

    public void cadastrar(Vaga vaga) throws SQLException, ClassNotFoundException {
        if (vaga.getSt_vaga() == null) vaga.setSt_vaga("ABERTA");
        vagaDAO.inserir(vaga);
    }
}