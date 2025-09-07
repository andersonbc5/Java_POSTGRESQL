package org.example.DAO;

import org.example.Connection.ConexaoBanco;
import org.example.Exceptions.BdExceptions;
import org.example.entidade.Produto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    ConexaoBanco conexaoBanco = new ConexaoBanco();

    public ProdutoDAO(Connection connection) {
    }

    public void create(Produto p){
        Connection con = conexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao, qtd, preco) VALUES(?,?,?)");
            stmt.setString(1,p.getDescricao());
            stmt.setInt(2,p.getQtd());
            stmt.setDouble(3,p.getPreco());

            stmt.executeUpdate();



        }catch (SQLException e){
            throw new BdExceptions("Erro ao salvar", e);
        }
        finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    public List<Produto> findAll(){
        Connection con = conexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
            }


        } catch (SQLException e) {
            throw new BdExceptions("Erro ao buscar todos os produtos: " + e.getMessage(), e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return produtos;
    }


    }
