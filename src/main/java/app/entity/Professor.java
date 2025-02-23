package app.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "O nome não pode estar vazio")
	@Pattern(regexp = "^\\S+\\s+\\S+.*$", message = "Nome deve ter um espaço entre palavas")
	private String nomeProfessor;
	
	@CPF(message = "O CPF tem que ser válido!")
	@NotBlank(message = "O cpf não pode estar vazio")
	private String cpf;
	
	@Email(message = "O email deve ser válido")
	@NotBlank(message = "O email não pode estar vazio")
	private String email;
	
	private String especialidade;
	
	@ManyToMany(mappedBy = "professores")
	@JsonIgnoreProperties("professores")
	@NotEmpty(message = "Não é possível ter um professor sem pelo menos uma turma assosciada")//não vai vazio
	private List<Turma> turmas;
	
}
