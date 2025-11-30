package br.edu.fatec.p2_gestao_alunos.controller;

import br.edu.fatec.p2_gestao_alunos.model.Aluno;
import br.edu.fatec.p2_gestao_alunos.repository.CursoRepository;
import br.edu.fatec.p2_gestao_alunos.model.Curso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", cursoRepository.findAll());
        return "cursos/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("curso", new Curso());
        return "cursos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Curso curso, BindingResult result) {
        if (result.hasErrors()) {
            return "cursos/formulario";
        }

        cursoRepository.save(curso);
        return "redirect:/cursos";
    }
}