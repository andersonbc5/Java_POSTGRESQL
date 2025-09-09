package org.example;

import org.example.Connection.ConexaoBanco;
import org.example.DAO.ProdutoDAO;
import org.example.Exceptions.BdExceptions;

import org.example.entidade.Produto;
import org.example.service.ProdutoService;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        ProdutoService produtoService = new ProdutoService();


        try {
            ConexaoBanco conexaoBanco = new ConexaoBanco();
            Connection connection = conexaoBanco.getConnection();
            System.out.println("Conexão obtida com sucesso!");

            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            Produto produto = new Produto();

            int opcao;
            do {
                System.out.println("---SISTEMA DE PRODUTOS---");
                System.out.println("1. CADASTRAR PRODUTO.");
                System.out.println("2. LISTAR PRODUTOS.");
                System.out.println("3. BUSCAR PRODUTO POR ID.");
                System.out.println("4. ATUALIZAR PRODUTO. ");
                System.out.println("5. EXCLUIR PRODUTO.");
                System.out.println("6. SAIR.");
                System.out.printf("ESCOLHA UMA OPÇÃO: ");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        produtoService.cadastrarProduto(produtoDAO, sc);
                        break;
                    case 2:
                        produtoService.listarProdutos(produtoDAO);
                        break;
                    case 3:
                        produtoService.buscarProdutoPorId(produtoDAO);
                        break;
                    case 4:
                        produtoService.atualizarProduto(produtoDAO, sc);
                        break;
                    case 5:
                        produtoService.excluirProduto(produtoDAO, sc);
                    case 6:
                        System.out.println("👋 Saindo do sistema...");
                        break;
                    default:
                        System.out.println("opcão invalida");
                }

            } while (opcao != 6);

            connection.close();
            System.out.println("Conexao fechada");


        } catch (SQLException e) {
            throw new BdExceptions("❌ erro no banco", e);

        }
    }


}
