package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	public List<Turma> findByAnoTurmaBetween(String anoInicio, String anoFim);
	
	public List<Turma> findByAnoTurmaAndSemestre(String anoTurma, String semestre);
	
	public List<Turma> findByNomeTurmaAndTurno(String nomeTurma, String turno);
	
	public List<Turma> findByCursoNomeCurso(String nomeCurso);
	
	




}
	