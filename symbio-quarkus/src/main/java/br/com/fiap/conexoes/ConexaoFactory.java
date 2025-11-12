package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    // Configurações de conexão com o banco de dados Oracle
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "RM563088";
    private static final String SENHA = "300107";

    /**
     * Método que estabelece e retorna uma conexão com o banco de dados
     * @return Connection objeto de conexão com o banco
     * @throws ClassNotFoundException se o driver JDBC não for encontrado
     * @throws SQLException se houver erro na conexão
     */
    public Connection conexao() throws ClassNotFoundException, SQLException {
        // Carrega o driver JDBC do Oracle
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Retorna a conexão estabelecida
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    /**
     * Método para fechar a conexão com o banco de dados
     * @param conexao objeto Connection a ser fechado
     */
    public void fecharConexao(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
