package org.example.service;

import org.example.DAO.ProdutoDAO;
import org.example.entidade.Produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoService {
    private ProdutoDAO produtoDAO;
    private Scanner sc;

    public ProdutoService(){
        this.produtoDAO = produtoDAO;
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

        System.out.println("\n--- LISTA DE PRODUTOS ---");
        List<Produto> produtos = produtoDAO.findAll();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p.toString());
        }
    }
}
