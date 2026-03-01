package com.lunetras.dto;

import java.time.LocalDate;

public class AlunoResponse {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private  String nomeTurma;

    public AlunoResponse(Long id, String nome, LocalDate dataNascimento, String nomeTurma) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nomeTurma = nomeTurma;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public  String getNomeTurma() {
        return nomeTurma;
    }
}
