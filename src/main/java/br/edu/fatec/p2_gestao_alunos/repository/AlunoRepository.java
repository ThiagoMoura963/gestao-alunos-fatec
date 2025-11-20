package br.edu.fatec.p2_gestao_alunos.repository;

import br.edu.fatec.p2_gestao_alunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
