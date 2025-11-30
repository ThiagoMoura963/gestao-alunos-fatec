package br.edu.fatec.p2_gestao_alunos.controller;

import br.edu.fatec.p2_gestao_alunos.model.Aluno;
import br.edu.fatec.p2_gestao_alunos.repository.AlunoRepository;
import br.edu.fatec.p2_gestao_alunos.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "alunos/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("listaCursos", cursoRepository.findAll());
        return "alunos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Aluno aluno, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("listaCursos", cursoRepository.findAll());

            return "alunos/formulario";
        }

        alunoRepository.save(aluno);
        return "redirect:/alunos";
    }
}