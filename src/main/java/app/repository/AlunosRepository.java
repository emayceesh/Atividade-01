package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Alunos;

public interface AlunosRepository extends JpaRepository<Alunos, Long>{
	
	public List<Alunos> findByNomeCompletoStartingWith(String nome);
	
	public List<Alunos> findByTelefoneContaining(String telefone);
	
	public List<Alunos> findByTurmaNomeTurma(String nomeTurma);
	
	public List<Alunos> findByCpf(String cpf);


}
