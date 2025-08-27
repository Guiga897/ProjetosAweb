package br.com.aweb.alunos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.com.aweb.alunos.model.Aluno;
import br.com.aweb.alunos.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("alunos", alunoService.listAll());
        return "alunos/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/form";
    }

    @PostMapping("/save")
    public String saveAluno(@ModelAttribute Aluno aluno) {
        alunoService.createAluno(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", alunoService.findAluno(id));
        return "alunos/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return "redirect:/alunos";
    }
}