package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.aluno;
import com.example.demo.repositories.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public long contarPautas() {
        return alunoRepository.count();
    }

    public aluno buscarAluno(Integer id) {
        return alunoRepository.findById(id).get();
    }

    public List<aluno> listarPautas() {
        return alunoRepository.findAll();
    }

    public Boolean deletarPauta(Integer id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public aluno cadastrarAluno(aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public aluno atualizarAluno(Integer id, aluno aluno) {
        aluno alunoRecuperado = buscarAluno(id);
        if (alunoRepository != null) {
            alunoRecuperado.setId(id);
            if (aluno.getNome() != null) {
                alunoRecuperado.setNome(aluno.getNome());
            }
            return alunoRepository.save(alunoRecuperado);
        }
        return null;
    }

}


