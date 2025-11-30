package br.edu.fatec.p2_gestao_alunos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Matrícula obrigatória")
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @NotNull(message = "Selecione um curso")
    private Curso curso;

    public Aluno() {}

    public Aluno(Long id, String nome, String email, String matricula, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.curso = curso;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getMatricula() { return matricula; }

    public void setMatricula(String matricula) { this.matricula = matricula; }

    public Curso getCurso() { return curso; }

    public void setCurso(Curso curso) { this.curso = curso; }
}
