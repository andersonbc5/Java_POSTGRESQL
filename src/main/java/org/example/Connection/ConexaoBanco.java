package org.example.Connection;

import org.example.Exceptions.BdExceptions;

import java.sql.*;


public class ConexaoBanco {
    private String url = "jdbc:postgresql://localhost:5432/estoque";
    private String user = "postgres";
    private String password = "12345678";
    private Connection connection;



    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver do PostgreSQL carregado com sucesso!");
        }catch (ClassNotFoundException e){
            throw new BdExceptions("Driver do PostgreSQL não encontrado", e);
        }
    }


    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao PostgreSQL!");
        } catch (SQLException e) {
            throw new BdExceptions("Erro ao conectar", e);
        }
        return connection;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new BdExceptions("Erro ao fechar conexão com o banco", e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            throw new BdExceptions("Erro ao fechar PreparedStatement", e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            throw new BdExceptions("Erro ao fechar ResultSet", e);
        }
    }
}