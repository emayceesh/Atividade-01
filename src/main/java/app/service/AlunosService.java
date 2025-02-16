package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Alunos;
import app.repository.AlunosRepository;

@Service
public class AlunosService {
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	public String save(Alunos alunos) {
		
		this.alunosRepository.save(alunos);
		
		return "Aluno matriculado com sucesso!";
		
	}
	
	public String update(Alunos alunos, long id) {
		
		
		
		return "Aluno aletrado com sucesso";
	}
	
	public String delete(long id) {
		
		
		
		return "Aluno deletado comm sucesso!";
	}
	
	public List<Alunos> findAll(){
		
		
		
		return null;
	}
	
	public Alunos findById(long id) {
		
		
		
		return null;
		
	}


}
