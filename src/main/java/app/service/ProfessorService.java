package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Alunos;
import app.entity.Professor;
import app.repository.ProfessorRepository;
import jakarta.transaction.Transactional;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Transactional
	public String save(Professor professor) {
		
		if (professor.getEmail() != null && professor.getEmail().contains("@outlook.com")) {
	        throw new RuntimeException("Domínio de e-mail não permitido");
	    }
		this.verificarEmailProfessor(professor.getEmail());
		
		this.professorRepository.save(professor);
		
		return "Professor matriculado com sucesso!";
		
	}
	
	public void verificarEmailProfessor(String email) {
		List<Professor> emailRepetido = professorRepository.findByEmail(email);
		if(!emailRepetido.isEmpty()) {
			throw new RuntimeException("Email já cadastrado!");
		}
	}
	
	public String update(Professor professor, long id) {
		
		professor.setId(id);
		this.professorRepository.save(professor);
		
		return "Professor alterado com sucesso";
	}
	
	public String delete(long id) {
		
		this.professorRepository.deleteById(id);
		
		return "Professor deletado comm sucesso!";
	}
	
	public List<Professor> findAll(){
		
		List<Professor> listaProfessor = this.professorRepository.findAll();
		
		return listaProfessor;
	}
	
	public Professor findById(long id) {
		
		Professor professor = this.professorRepository.findById(id).get();
		
		return professor;
		
	}
	
	public List<Professor> findByNomeProfessorStartingWith (String nomeProfessor){
		
		 return professorRepository.findByNomeProfessorStartingWith(nomeProfessor);
		
	}
	
	public List<Professor> findByEspecialidadeStartingWith (String especialidade){
		
		 return professorRepository.findByEspecialidadeStartingWith(especialidade);
		
	}
	
	public List<Professor> findByEmailNotLike(String emailPattern){
		
		return professorRepository.findByEmailNotLike("%@gmail.com%");
	}
	
	public List<Professor> findByEmail (String email){
		return professorRepository.findByEmail(email);
	}


}
