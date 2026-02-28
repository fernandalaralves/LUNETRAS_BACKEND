package controller;

import  com.lunetras.model.Turma;
import  com.lunetras.service.TurmaService;
import  org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.*;

import  java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    //criar turma
    @PostMapping
    public ResponseEntity<Turma> criar(@RequestBody Turma turma) {
        Turma turmaSalva = turmaService.salvar(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        Turma turma = turmaService.buscarPorId(id);
        return ResponseEntity.ok(turma);
    }

    //listar as turmas
    @GetMapping
    public ResponseEntity<List<Turma>> listarTodas() {
        List<Turma> turmas = turmaService.listarTodas();
        return ResponseEntity.ok(turmas);
    }

    //remove turma
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        turmaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
