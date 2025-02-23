package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome não pode estar vazio")
	private String nomeTurma;

	@NotNull(message = "O campo semestre não pode estar vazio")
	private String semestre;

	@NotBlank(message = "O ano não pode estar vazio")
	private String anoTurma;

	@NotBlank(message = "O turno não pode estar vazio")
	private String turno;

	@OneToMany(mappedBy = "turma")
	@JsonIgnoreProperties("")
	private List<Alunos> alunos;

	@ManyToOne(cascade = CascadeType.MERGE)
	@NotNull(message = "O curso é origatório para salvar uma turma")
	private Curso curso;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
	    name = "turma-professor",
	    joinColumns = @JoinColumn(name = "turma_id"),
	    inverseJoinColumns = @JoinColumn(name = "professor_id")
	)
	@JsonIgnoreProperties("turmas")
	@NotEmpty(message = "Não é possível ter uma turma sem pelo menos um professor associado")
	private List<Professor> professores;


}
