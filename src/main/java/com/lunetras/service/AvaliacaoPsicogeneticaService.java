package com.lunetras.service;

import com.lunetras.model.Aluno;
import com.lunetras.model.AvaliacaoPsicogenetica;

public class AvaliacaoPsicogeneticaService {

    //um aluno não pode ter mais de uma avaliação no mesmo bimestre
    public void adicionarAvaliacao(Aluno aluno, AvaliacaoPsicogenetica novaAvaliacao) {

        boolean jaExisteAvaliacaoNoBimestre = aluno.getAvaliacoes()
                .stream()
                .anyMatch(avaliacao ->
                        avaliacao.getBimestre() == novaAvaliacao.getBimestre()
                );

        if (jaExisteAvaliacaoNoBimestre) {
            throw new IllegalArgumentException(
                    "O aluno já posssui uma avaliação para este bimestre"
            );
        }
        aluno.getAvaliacoes().add(novaAvaliacao);
        }
    }

