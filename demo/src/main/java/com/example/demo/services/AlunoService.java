package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Aluno;
import com.example.demo.repositories.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public long contarPautas() {
        return alunoRepository.count();
    }

    public Aluno buscarAluno(Integer id) {
        return alunoRepository.findById(id).get();
    }

    public List<Aluno> listarPautas() {
        return alunoRepository.findAll();
    }

    public Boolean deletarPauta(Integer id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Integer id, Aluno aluno) {
        Aluno alunoRecuperado = buscarAluno(id);
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


