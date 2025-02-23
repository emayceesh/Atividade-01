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
		
		verificarTelefoneAluno(alunos);
		this.verificarCpfAluno(alunos.getCpf());
		
		this.alunosRepository.save(alunos);
		return "Aluno matriculado com sucesso!";	
	}
	
	public void verificarTelefoneAluno(Alunos alunos) {
		if (alunos.getTelefone() == null || alunos.getTelefone().isEmpty()) {
			alunos.setCadastroCompleto(false);
		}else {
			alunos.setCadastroCompleto(true);
		}
	}
	
	public void verificarCpfAluno(String cpf) {
		List<Alunos> alunosComCpf = alunosRepository.findByCpf(cpf);
		if(!alunosComCpf.isEmpty()) {
			throw new RuntimeException("CPF já cadastrado!");
		}
	}
	
	public String update(Alunos alunos, long id) {
		
		this.verificarTelefoneAluno(alunos);
		this.verificarCpfAluno(alunos.getCpf());

		
		alunos.setId(id);
		this.alunosRepository.save(alunos);
		
		return "Aluno alterado com sucesso";
	}
	
	public String delete(long id) {
		
		this.alunosRepository.deleteById(id);
		
		return "Aluno deletado comm sucesso!";
	}
	
	public List<Alunos> findAll(){
		
		List<Alunos> listaAlunos = this.alunosRepository.findAll();
		
		return listaAlunos;
	}
	
	public Alunos findById(long id) {
		
		Alunos alunos = this.alunosRepository.findById(id).get()	;
		
		return alunos;
	}
	
	public List<Alunos> findByCpf(String cpf){
		return this.alunosRepository.findByCpf(cpf);
	}
	
	public List<Alunos> findByNomeCompleto (String nome){
		
		return this.alunosRepository.findByNomeCompletoStartingWith(nome);	
		
	}
	
	public List<Alunos> findByTelefone (String telefone){
		return alunosRepository.findByTelefoneContaining(telefone);
	}
	
	public List<Alunos> findByNomeTurma (String nomeTurma){
		return alunosRepository.findByTurmaNomeTurma(nomeTurma);
	}


}
