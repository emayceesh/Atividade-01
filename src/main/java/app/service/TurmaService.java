package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;
import jakarta.transaction.Transactional;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	
	public String save(Turma turma) {
		
		this.turmaRepository.save(turma);
		
		return "Turma cadastrada com sucesso!";
		
	}
	
	public String update(Turma turma, long id) {
		
		turma.setId(id);
		this.turmaRepository.save(turma);
		
		return "Turma alterado com sucesso";
	}
	
	public String delete(long id) {
		
		this.turmaRepository.deleteById(id);
		
		return "Turma deletada comm sucesso!";
	}
	
	public List<Turma> findAll(){
		
		List<Turma> listaTurma = this.turmaRepository.findAll();
		
		return listaTurma;
	}
	
	public Turma findById(long id) {
		
		Turma alunos = this.turmaRepository.findById(id).get();
		
		return alunos;
		
	}


}
