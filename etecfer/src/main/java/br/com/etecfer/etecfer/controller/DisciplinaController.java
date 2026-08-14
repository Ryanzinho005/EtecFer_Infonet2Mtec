package br.com.etecfer.etecfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.entity.Curso;
import br.com.etecfer.etecfer.entity.Disciplina;
import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.service.CursoService;
import br.com.etecfer.etecfer.service.DisciplinaService;
import br.com.etecfer.etecfer.service.ProfessorService;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfessorService professorService;

    // Método para salvar uma disciplina
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Disciplina disciplina) {
        disciplinaService.save(disciplina);
        return "redirect:/disciplinas/listar";
    }

    // Método para listar todas as disciplinas
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Disciplina> disciplinas = disciplinaService.findAll();
        model.addAttribute("disciplinas", disciplinas);

        return "disciplina/listarDisciplinas";
    }

    // Método para criar formulário de uma nova disciplina
    @GetMapping("/criar")
    public String criarForm(Model model) {

        model.addAttribute("disciplina", new Disciplina());

        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);

        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);

        return "disciplina/formularioDisciplina";
    }

    // Método para excluir uma disciplina
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {

        disciplinaService.deleteById(id);

        return "redirect:/disciplinas/listar";
    }

    // Método para abrir o formulário de edição de disciplina
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {

        Disciplina disciplina = disciplinaService.findById(id);
        model.addAttribute("disciplina", disciplina);

        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);

        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);

        return "disciplina/formularioDisciplina";
    }
}
