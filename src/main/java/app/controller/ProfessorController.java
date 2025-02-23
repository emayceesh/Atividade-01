package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Alunos;
import app.entity.Professor;
import app.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody Professor professor){

		try {
			String mensagem = this.professorService.save(professor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Professor professor,@PathVariable long id) {

		try {
			String mensagem = this.professorService.update(professor, id);	
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.professorService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/findAll")
	public ResponseEntity <List<Professor>> findAll(){

		try {
			List<Professor> listaProfessor = this.professorService.findAll();
			return new ResponseEntity<>(listaProfessor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity <Professor> findById(long id){


		return null;
	}
	
	@GetMapping("/findByNomeProfessor")
	public ResponseEntity<List<Professor>> findByNomeProfessorStartingWith(@RequestParam String nomeProfessor) {
		
		try {
			List<Professor> lista = this.professorService.findByNomeProfessorStartingWith(nomeProfessor);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findByEspecialidade")
	public ResponseEntity<List<Professor>> findByEspecialidadeStartingWith(@RequestParam String especialidade) {
		
		try {
			List<Professor> lista = this.professorService.findByEspecialidadeStartingWith(especialidade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findByEmailNotLike")
	public ResponseEntity<List<Professor>> findByEmailNotLike(@RequestParam String emailPattern) {
		try {
			List<Professor> lista = this.professorService.findByEmailNotLike(emailPattern);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<List<Professor>> findByEmail(@RequestParam String email) {
		try {
			List<Professor> lista = this.professorService.findByEmail(email);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
