package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Aluno;
import br.senai.sp.escolamvc.model.Professor;
import br.senai.sp.escolamvc.repository.AlunoRepository;
import br.senai.sp.escolamvc.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/professor")
public class ProfessorRestController {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Professor professor) {
        professorRepository.save(professor);
    }

    @PutMapping("/alterar")
    public void alterar(@RequestBody Professor professor) {
        professorRepository.save(professor);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }

    @GetMapping("/buscar/{nome}")
    public List<Professor> buscar(@PathVariable String nome) {
        return professorRepository.findProfessorsByNomeContaining(nome);
    }

    @GetMapping("/buscar-por-cpf/{cpf}")
    public List<Professor> buscarPorCPF(@PathVariable String cpf) {
        return professorRepository.findProfessorsByCpf(cpf);
    }

    @GetMapping("/buscar-por-id/{id}")
    public Professor buscarPorId(@PathVariable Long id) {
        return professorRepository.findById(id).get();
    }

    @PostMapping("/inserir-varios")
    public void inserirVarios(@RequestBody List<Professor> professors) {
        professorRepository.saveAll(professors);
    }


}
