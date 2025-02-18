package app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
	@NotBlank(message = "O campo semestre não pode estar vazio")
	private long semestre;
	@NotBlank(message = "O ano não pode estar vazio")
	private String anoTurma;
	@NotBlank(message = "O turno não pode estar vazio")
	private String Turno;
	
	@OneToMany(mappedBy = "turma")
	private List<Alunos> alunos;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Curso curso;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="turma-professor"
			)
	private List<Professor> professor;
	
	
	
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
