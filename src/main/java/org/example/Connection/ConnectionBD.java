package org.example.Connection;

import org.example.Exceptions.BdExceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

    private String url = "jdbc:postgresql://localhost:5432/cadastro";
    private String user = "postgres";
    private String password = "12345678";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ConnectionBD(){
        try{
            this.connection = DriverManager.getConnection(url,user,password);
            if (connection != null){
                System.out.println("   ✅ CONEXÃO BEM-SUCEDIDA!");
            }else {
                throw new BdExceptions("FALHA AO CONECTAR.");
            }

        } catch (SQLException e) {
            throw new BdExceptions("❌ ERRO DE CONEXÃO:", e);
        }
    }
}