package org.example.entidade;

public class Produto {
    private Integer id;         // pode ser null antes de salvar
    private String descricao;
    private int qtd;            // primitivo
    private double preco;       // primitivo

    public Produto() {}

    public Produto(String descricao, int qtd, double preco) {
        this.descricao = descricao;
        this.qtd = qtd;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | DESCRIÇÃO: %s | QUANTIDADE: %d | PREÇO: R$ %.2f",
                id, descricao, qtd, preco
        );
    }
}
