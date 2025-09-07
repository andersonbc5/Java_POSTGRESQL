package org.example.entidade;

public class Produto {
    private Integer id;
    private String descricao;
    private Integer qtd;
    private Double preco;


    public Produto() {}

    public Produto(String descricao, Integer qtd, Double preco) {
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

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }


    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | DESCRIÇÃO: %s | QUANTIDADE: %d | PREÇO: R$ %.2f",
                id, descricao, qtd, preco);
    }
}