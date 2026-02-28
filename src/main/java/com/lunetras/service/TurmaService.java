package com.lunetras.service;

import com.lunetras.model.Turma;
import com.lunetras.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService (TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    //criar/salvar turma
    public Turma salvar(Turma turma) {
        validarTurma(turma);
        return turmaRepository.save(turma);
    }

    //buscar turma pelo id
    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Turma não encontrada"));
    }

    //Listar todas as turmas
    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    //Remover turma
    public void remover(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new IllegalArgumentException("Turma não encontrada");
        }
        turmaRepository.deleteById(id);
    }

    //rn
    private void validarTurma (Turma turma) {
        if(turma == null) {
            throw  new IllegalArgumentException("Turma não pode ser nula");
        }

        if (turma.getNome() == null || turma.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome da turma é obrigatório");
        }
        if (turma.getAnoLetivo() == null) {
            throw new IllegalArgumentException("Ano da turma é obrigatório");
        }
    }
}
