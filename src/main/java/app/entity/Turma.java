package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	@JsonIgnoreProperties("")
	private List<Alunos> alunos;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@NotNull(message = "O curso é origatório para salvar uma turma")
	private Curso curso;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="turma-professor")
	@JsonIgnoreProperties("turmas")
	@NotEmpty(message = "Não é possível ter uma turma sem pelo menos um professor assosciado")//não vai vazio
	private List<Professor> professores;
}
