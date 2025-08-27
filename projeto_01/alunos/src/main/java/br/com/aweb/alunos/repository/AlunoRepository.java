package br.com.aweb.alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.aweb.alunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}