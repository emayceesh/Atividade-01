package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository alunosRepository;
	
	public String save(Turma alunos) {
		
		this.alunosRepository.save(alunos);
		
		return "Aluno matriculado com sucesso!";
		
	}
	
	public String update(Turma alunos, long id) {
		
		alunos.setId(id);
		this.alunosRepository.save(alunos);
		
		return "Aluno alterado com sucesso";
	}
	
	public String delete(long id) {
		
		this.alunosRepository.deleteById(id);
		
		return "Aluno deletado comm sucesso!";
	}
	
	public List<Turma> findAll(){
		
		List<Turma> listaTurma = this.alunosRepository.findAll();
		
		return listaTurma;
	}
	
	public Turma findById(long id) {
		
		Turma alunos = this.alunosRepository.findById(id).get();
		
		return alunos;
		
	}


}
