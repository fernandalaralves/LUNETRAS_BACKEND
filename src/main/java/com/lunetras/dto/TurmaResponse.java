package com.lunetras.dto;

public class TurmaResponse {
    private String nome;
    private Integer ano;
    private String email;

    public String getNome() {
        return nome;
    }

    public Integer getAno() {
        return ano;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
