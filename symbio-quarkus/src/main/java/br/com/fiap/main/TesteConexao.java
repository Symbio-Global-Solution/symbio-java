package br.com.fiap.main;

import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        try {
            Connection conexao = new ConexaoFactory().getConexao();
            System.out.println("========================================");
            System.out.println("Conectado com sucesso ao banco de dados!");
            System.out.println("========================================");
            conexao.close();
            System.out.println("Conexão fechada com sucesso!");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }
}
