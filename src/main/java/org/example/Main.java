package org.example;




import org.example.Connection.ConnectionBD;
import org.example.Exceptions.BdExceptions;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {

        try {

            ConnectionBD connectionBD = new ConnectionBD();
            Connection connection = connectionBD.getConnection();


        } catch (BdExceptions e) {
            System.out.println("❌ Erro no Banco de Dados:" + e.getMessage());
        } catch (Exception e){
            System.out.println("Erro inesperado:" + e.getMessage());
        }
    }}