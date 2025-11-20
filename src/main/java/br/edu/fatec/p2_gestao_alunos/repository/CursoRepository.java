package br.edu.fatec.p2_gestao_alunos.repository;

import br.edu.fatec.p2_gestao_alunos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
