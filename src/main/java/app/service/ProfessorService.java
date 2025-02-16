package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		
		this.professorRepository.save(professor);
		
		return "Aluno matriculado com sucesso!";
		
	}
	
	public String update(Professor professor, long id) {
		
		professor.setId(id);
		this.professorRepository.save(professor);
		
		return "Aluno alterado com sucesso";
	}
	
	public String delete(long id) {
		
		this.professorRepository.deleteById(id);
		
		return "Aluno deletado comm sucesso!";
	}
	
	public List<Professor> findAll(){
		
		List<Professor> listaProfessor = this.professorRepository.findAll();
		
		return listaProfessor;
	}
	
	public Professor findById(long id) {
		
		Professor professor = this.professorRepository.findById(id).get();
		
		return professor;
		
	}


}
