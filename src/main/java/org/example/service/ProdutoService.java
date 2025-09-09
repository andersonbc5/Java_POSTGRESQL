package org.example.service;

import org.example.DAO.ProdutoDAO;
import org.example.entidade.Produto;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    private ProdutoDAO produtoDAO;
    private final Scanner sc;

    public ProdutoService() {
        this.sc = new Scanner(System.in);
    }

    public void cadastrarProduto(ProdutoDAO produtoDAO, Scanner sc) {

        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("\n--- CADASTRAR PRODUTO ---");

                sc.nextLine(); // limpar buffer
                System.out.printf("Descrição: ");
                String descricao = sc.nextLine();

                System.out.printf("Quantidade: ");
                int qtd = Integer.parseInt(sc.nextLine()); // evita InputMismatch

                System.out.printf("Preço (R$): ");
                double preco = Double.parseDouble(sc.nextLine()); // evita InputMismatch

                Produto produto = new Produto(descricao, qtd, preco);
                produtoDAO.create(produto);

                System.out.println("✅ Produto cadastrado com sucesso!");

                System.out.print("Deseja cadastrar outro produto? (s/n): ");
                String resposta = sc.nextLine().trim().toLowerCase();
                if (!resposta.equals("s")) {
                    continuar = false; // sai do loop de cadastro
                }

            } catch (Exception e) {
                System.out.println("❌ Erro ao cadastrar produto.");
                e.printStackTrace(); // para debug real do erro no DAO
            }
        }

    }

    public void listarProdutos(ProdutoDAO produtoDAO) {
        try {
            List<Produto> produtos = produtoDAO.findAll();

            if (produtos.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
                return;
            }

            System.out.println("\n LISTA DE PRODUTOS");
            System.out.println("==============================================");
            System.out.printf("%-4s %-20s %-8s %-10s%n", "ID", "DESCRIÇÃO", "QTD", "PREÇO");
            System.out.println("==============================================");

            for (Produto produto : produtos) {
                System.out.printf("%-4d %-20s %-8d R$ %-8.2f%n",
                        produto.getId(),
                        produto.getDescricao(),
                        produto.getQtd(),
                        produto.getPreco());
            }

            System.out.println("==============================================");
            System.out.println("Total de produtos: " + produtos.size());
        } catch (Exception e) {
            System.out.println("❌ Erro ao listar produtos: " + e.getMessage());
        }
    }

        public void buscarProdutoPorId (ProdutoDAO produtoDAO){
            try {
                System.out.println("Digite o ID do Produto:");
                int id = sc.nextInt();
                sc.nextLine();

                Produto produto = produtoDAO.findById(id);
                if (produto != null) {
                    System.out.println("\n✅ Produto encontrado:");
                    System.out.println("ID: " + produto.getId());
                    System.out.println("Descrição: " + produto.getDescricao());
                    System.out.println("Quantidade: " + produto.getQtd());
                    System.out.println("Preço: R$ " + String.format("%.2f", produto.getPreco()));
                } else {
                    System.out.println("❌ Nenhum produto encontrado com ID: " + id);
                }
            } catch (Exception e) {
                System.out.println("❌ Erro ao buscar produto: " + e.getMessage());
            }
        }

        public void atualizarProduto (ProdutoDAO produtoDAO, Scanner sc){
            try {
                System.out.println("\n--- ATUALIZAR PRODUTO ---");

                System.out.print("Informe o ID do produto a atualizar: ");
                int id = sc.nextInt();
                sc.nextLine(); // limpar buffer

                // Primeiro buscar o produto existente
                Produto existente = produtoDAO.findById(id);

                if (existente == null) {
                    System.out.println("❌ Nenhum produto encontrado com ID: " + id);
                    return;
                }

                System.out.println("\nProduto atual:");
                System.out.println(existente);

                // Pedir novos valores
                System.out.print("Nova descrição (atual: " + existente.getDescricao() + "): ");
                String novaDescricao = sc.nextLine();

                System.out.print("Nova quantidade (atual: " + existente.getQtd() + "): ");
                int novaQtd = sc.nextInt();

                System.out.print("Novo preço (R$) (atual: " + existente.getPreco() + "): ");
                double novoPreco = sc.nextDouble();

                // Atualizar os campos
                existente.setDescricao(novaDescricao.isEmpty() ? existente.getDescricao() : novaDescricao);
                existente.setQtd(novaQtd);
                existente.setPreco(novoPreco);

                // Chamar DAO para atualizar
                produtoDAO.atualizarProduto(existente);

                System.out.println("✅ Produto atualizado com sucesso!");
            } catch (Exception e) {
                System.out.println("❌ Erro ao atualizar produto: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public void excluirProduto (ProdutoDAO produtoDAO, Scanner sc){
            try {
                System.out.println("\n---ESCLUIR PRODUTO---");
                System.out.print("Informe o ID do produto para excluir: ");
                int id = sc.nextInt();
                sc.nextLine(); // limpar

                Produto produto = produtoDAO.findById(id);

                if (produto == null) {
                    System.out.println("PRODUTO COM ID " + id + " não encontrado!");
                    return;
                }

                produtoDAO.excluirProduto(id);
                System.out.println("Produto excluido com sucesso!");
            } catch (Exception e) {
                System.out.println("❌ Erro ao excluir produto: " + e.getMessage());

            }
        }


    }

