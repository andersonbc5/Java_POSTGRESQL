package org.example.model;

import java.time.LocalDate;

public class Dependente {

    private Integer codFuncionario;
    private Integer numDependente;
    private String nome;
    private LocalDate dataNascimento;
    private Funcionario funcionario;

    public Dependente(){

    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Integer getNumDependente() {
        return numDependente;
    }

    public void setNumDependente(Integer numDependente) {
        this.numDependente = numDependente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
