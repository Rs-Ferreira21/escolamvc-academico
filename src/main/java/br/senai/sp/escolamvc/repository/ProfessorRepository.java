package br.senai.sp.escolamvc.repository;

import br.senai.sp.escolamvc.model.Professor;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository  extends JpaRepository<Professor, Long> {
    List<Professor> findProfessorsByNomeContaining(String nome);
    List<Professor> findProfessorsByCpf(String cpf);
}

