package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	public List<Professor> findByNomeProfessorStartingWith(String nomeProfessor);

	public List<Professor> findByEspecialidadeStartingWith(String especialidade);
	
	public List<Professor> findByEmailNotLike(String emailPattern);
	
	public List<Professor> findByEmail(String email);

}
