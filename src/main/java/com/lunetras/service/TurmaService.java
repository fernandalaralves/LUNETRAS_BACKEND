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

    public TurmaResponse criar(TurmaRequest request) {

        //rn
        if(request.getAno() < 1 || request.getAno() > 5) {
            throw new IllegalArgumentException(
                    "O ano da turma deve estar entre o primeiro e o quinto ano"
            );
        }

        Turma turma = new Turma(
                request.getNome(),
                request.getAno()
        );

        Turma salva = turmaRepository.save(turma);

        return new TurmaResponse(
                salva.getId(),
                salva.getNome(),
                salva.getAno()
        );
    }
}