package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public String save(Curso curso) {
		
		this.cursoRepository.save(curso);
		
		return "Curso adicionado com sucesso!";
		
	}
	
	public String update(Curso curso, long id) {
		
		curso.setId(id);
		this.cursoRepository.save(curso);
		
		return "Curso alterado com sucesso";
	}
	
	public String delete(long id) {
		
		this.cursoRepository.deleteById(id);
		
		return "Curso deletado comm sucesso!";
	}
	
	public List<Curso> findAll(){
		
		List<Curso> listaCurso = this.cursoRepository.findAll();
		
		return listaCurso;
	}
	
	public Curso findById(long id) {
		
		Curso curso = this.cursoRepository.findById(id).get();
		
		return curso;
		
	}


}
