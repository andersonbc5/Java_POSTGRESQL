package org.example.model;

import java.time.LocalDate;

public class Funcionario {
    private Integer codFuncionario;
    private String nome;
    private String cpf;
    private Character sexo;
    private LocalDate dataNascimento;

    public Funcionario(){

    }

    public Funcionario(Integer codFuncionario, String nome, String cpf, Character sexo, LocalDate dataNascimento) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

