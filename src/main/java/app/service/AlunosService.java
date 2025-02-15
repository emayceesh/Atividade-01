package app.service;

import org.springframework.stereotype.Service;

import app.entity.Alunos;

@Service
public class AlunosService {
	
	public String save(Alunos alunos) {
		
		return "Aluno matriculado com sucesso!";
		
	}


}
