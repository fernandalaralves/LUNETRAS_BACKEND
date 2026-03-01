package com.lunetras.service;

import com.lunetras.dto.TurmaRequest;
import com.lunetras.dto.TurmaResponse;
import com.lunetras.model.Turma;
import com.lunetras.repository.TurmaRepository;
import org.springframework.stereotype.Service;



@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma criar(TurmaRequest request) {

        Turma turma = new Turma();
        turma.setNome(request.getNome());
        turma.setTurno(request.getTurno());

        return turmaRepository.save(turma);
    }
}