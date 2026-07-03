package br.com.etecfer.etecfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.repository.ProfessorRepository;

@Service
public class ProfessorService {

    // Injeção de dependência do repositório para a classe professor
    @Autowired
    private ProfessorRepository professorRepository;

    //Método para salvar curso
    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }

    //método para listar todos os cursos
    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    // Método para excluir um curso pelo id
    public void deleteById(Integer id){
        professorRepository.deleteById(id);
    }

    //Método para buscar aluno pelo id
    public Professor findById(Integer id){
        return professorRepository.findById(id).orElse(null);
    }
    
}

