package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long semestre;
	private String anoTurma;
	private String Turno;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSemestre() {
		return semestre;
	}
	public void setSemestre(long semestre) {
		this.semestre = semestre;
	}
	public String getAnoTurma() {
		return anoTurma;
	}
	public void setAnoTurma(String anoTurma) {
		this.anoTurma = anoTurma;
	}
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
	}
	
	
	
	
	
}
