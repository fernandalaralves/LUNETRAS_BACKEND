package com.lunetras.service;

import com.lunetras.model.Aluno;
import com.lunetras.model.AvaliacaoPsicogenetica;
import com.lunetras.model.Turma;
import com.lunetras.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Cadastrar um novo aluno
    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Buscar aluno por ID
    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // Associar aluno a uma turma
    public void associarTurma(Long alunoId, Turma turma) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        aluno.setTurma(turma);
        alunoRepository.save(aluno);
    }

    // Regra de negócio: adicionar avaliação ao aluno
    public void adicionarAvaliacao(Long alunoId, AvaliacaoPsicogenetica avaliacao) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        /*
         * A regra "um aluno não pode ter mais de uma avaliação no mesmo bimestre"
         * está protegida dentro da entidade Aluno.
         * O Service apenas coordena o fluxo.
         */
        aluno.adicionarAvaliacao(avaliacao);

        alunoRepository.save(aluno);
    }
}