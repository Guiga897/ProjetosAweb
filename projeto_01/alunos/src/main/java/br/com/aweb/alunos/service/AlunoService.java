package br.com.aweb.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.alunos.model.Aluno;
import br.com.aweb.alunos.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listAll(){
        return alunoRepository.findAll();
    }

    public Aluno findAluno(Long id){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if(optionalAluno.isPresent())
            return optionalAluno.get();
        throw new RuntimeException("Aluno não encontrado");
    } 

    public Aluno createAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void deleteAluno(Long id){
        if(!alunoRepository.existsById(id))
            throw new RuntimeException("Aluno não encontrado");
        alunoRepository.deleteById(id);
    }
}