package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; 

    @Column(name = "turma")
    private String turma;

    @OneToMany 
    @JoinColumn(name = "id_turma") 
    private List<aluno> alunos;

    public turma() {
    }

    public turma(Integer id, String turma, List<aluno> alunos) {
        this.id = id;
        this.turma = turma;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<aluno> getUsuarios() {
        return alunos;
    }

    public void setUsuarios(List<aluno> usuarios, List<aluno> alunos) {
        this.alunos = alunos;
    }

}
