package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Turma;
import com.example.demo.services.TurmaService;

@RestController
@RequestMapping
public class TurmaController {
    
    @Autowired
    private TurmaService turmaService;

     @GetMapping("/contar-turmas")
    public Long contarturmas() {
        return turmaService.contarTurma();
    }

    @GetMapping("/buscar-turmas/{id}")
    public Turma buscarturma(@PathVariable Integer id) {
        return turmaService.buscarTurma(id);

    }

    @GetMapping("/listar-turmas")
    public List<Turma> listarturmas() {
        return turmaService.listarTurma();
    }

    @DeleteMapping("/deletar-turma/{id}")
    public String deletarturma(@PathVariable Integer id) {
        if (turmaService.deletarTurma(id)) {
            return "turma excluida com sucesso";

        }
        return "Falha na exclusão da turma";
    }

    @PostMapping("/salvar-turma")
    public Turma cadastrarTurma(@RequestBody Turma turma) {
        return turmaService.cadastrarTurma(turma);
    }

    @PutMapping("/atualizar-turma/{id}")
    public String atualizarturma(@PathVariable Integer id, @RequestBody Turma turma) {
        if (turmaService.atualizarTurma(id, turma) != null) {
            return "turma atualizada com sucesso";
        }
        return "Falha na atualizção da turma";
    }
}

