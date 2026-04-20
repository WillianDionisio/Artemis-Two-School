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

import com.example.demo.models.Aluno;
import com.example.demo.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/contar-alunos")
    public Long contarAlunos() {
        return alunoService.contarAlunos();
    }

    @GetMapping("/buscar-aluno/{id}")
    public Aluno buscarAluno(@PathVariable Integer id) {
        return alunoService.buscarAluno(id);
    }

    @GetMapping("/listar-alunos")
    public List<Aluno> listaAlunos() {
        return alunoService.listarAlunos();

    }

    @DeleteMapping("/deletar-aluno/{id}")
    public String deletarAluno(@PathVariable Integer id) {
        if (alunoService.deletarAlunos(id)) {
            return "Usuário deletado com sucesso";
        }
        return "Falha ao deletar o aluno";
    }

    @PostMapping("/salvar-aluno")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.cadastrarAluno(aluno);
    }

    @PutMapping("/atualizar-aluno/{id}")
    public String atualizaAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
        if (alunoService.atualizarAluno(id, aluno) != null) {
            return "Aluno atualizado com sucesso";
        }
        return "Falha ao atualizar o Aluno";
    }
}