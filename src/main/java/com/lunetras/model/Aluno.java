package com.lunetras.model;

 import java.time.LocalDate;
 import java.util.ArrayList;
 import java.util.List;


public class Aluno {


    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    //um aluno pode ter várias avaliações ao longo do tempo
    private List<AvaliacaoPsicogenetica> avaliacoes = new ArrayList<>();

    //relacionamento com a turma
    private Turma turma;

    public Aluno() {
    }
    public Aluno (Long id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public List<AvaliacaoPsicogenetica> getAvaliacoes(){
        return avaliacoes;
    }
    public Turma getTurma() {
        return turma;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    //um aluno não pode ter mais de uma avaliação no mesmo bimestre
    public void adicionarAvaliacao(AvaliacaoPsicogenetica avaliacao) {
        for (AvaliacaoPsicogenetica a: avaliacoes) {
            if (a.getBimestre() == avaliacao.getBimestre()) {
                throw new IllegalArgumentException(
                        "O aluno já possui uma avaliação para este bimestre."
                );
            }
        }
        avaliacoes.add(avaliacao);
    }
}







