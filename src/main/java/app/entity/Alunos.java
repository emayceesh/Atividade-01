package app.entity;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alunos {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O nome não pode estar vazio")
	@Pattern(regexp = "^\\S+\\s+\\S+.*$", message = "Nome deve ter um espaço entre palavas")
	private String nomeCompleto;
	
	
	@NotBlank(message = "O cpf não pode estar vazio")
	private String cpf;
	
	private String telefone;
	
	private Boolean cadastroCompleto;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("alunos")
	private Turma turma;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Curso curso;
	
}
