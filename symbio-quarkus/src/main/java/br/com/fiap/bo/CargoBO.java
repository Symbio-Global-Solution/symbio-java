package br.com.fiap.bo;

import br.com.fiap.beans.Cargo;
import br.com.fiap.dao.CargoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class CargoBO {

    public CargoDAO cargoDAO;

    //Selecionar
    public ArrayList<Cargo> selecionarBo() throws SQLException, ClassNotFoundException {
        cargoDAO = new CargoDAO();

        //Regra de negócio
        return (ArrayList<Cargo>) cargoDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Cargo cargo) throws SQLException, ClassNotFoundException {
        CargoDAO cargoDAO = new CargoDAO();

        //Regra de negócio
        cargoDAO.inserir(cargo);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        CargoDAO cargoDAO = new CargoDAO();

        //Regra de negócio
        cargoDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Cargo cargo) throws SQLException, ClassNotFoundException {
        CargoDAO cargoDAO = new CargoDAO();

        // Regra de negócios
        cargoDAO.atualizar(cargo);
    }
}