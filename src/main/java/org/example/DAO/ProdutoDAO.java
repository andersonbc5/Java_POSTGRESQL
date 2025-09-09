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

    //CREATE
    public void create(Produto p) {
        Connection con = conexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao, qtd, preco) VALUES(?,?,?)");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());

            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new BdExceptions("Erro ao salvar", e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    //LISTAR TODOS PRODUTOS DO BANCO
    public List<Produto> findAll() {
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

    //LISTAR POR ID
    public Produto findById(int id) {
        Connection con = conexaoBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT id, descricao, qtd, preco FROM produto WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                return produto;
            }

            return null;
        } catch (SQLException e) {
            throw new BdExceptions("Erro ao buscar produto com ID: " + id, e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

    }

    //UPDATE
    public Produto atualizarProduto(Produto produto) {
        if (produto.getId() == null) {
            throw new BdExceptions("ID do produto não pode ser nulo para atualização.");
        }

        Connection con = conexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "UPDATE produto SET descricao = ?, qtd = ?, preco = ? WHERE id = ?"
            );

            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getQtd());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new BdExceptions("Nenhum produto encontrado com ID: " + produto.getId());
            }

            return produto;
        } catch (SQLException e) {
            throw new BdExceptions("Erro ao atualizar produto: " + e.getMessage(), e);
        } finally {
            ConexaoBanco.closeConnection(con, stmt);
        }
    }

    //DELETEE
    public void excluirProduto(int id){
        Connection con = conexaoBanco.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setInt(1,id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0){
                throw new BdExceptions("Nenhum produto encontrado com ID: " + id);
            }
        }catch (SQLException e){
            throw new BdExceptions("Erro ao deletar produto com ID: " + id , e);
        }finally {
            ConexaoBanco.closeConnection(con, stmt);
        }

    }
}