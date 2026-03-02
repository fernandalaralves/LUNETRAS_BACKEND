package com.lunetras.dto;

public class TurmaResponse {
    private Long id;
    private String nome;
    private Integer ano;

    public TurmaResponse(Long id, String nome, Integer ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAno() {
        return ano;
    }
}



