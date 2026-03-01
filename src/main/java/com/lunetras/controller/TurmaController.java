package com.lunetras.controller;

import com.lunetras.dto.TurmaRequest;
import com.lunetras.model.Turma;
import com.lunetras.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "*")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public ResponseEntity<Turma> criar(
            @RequestBody @Valid TurmaRequest request
    ) {
        Turma turma = turmaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(turma);
    }
}