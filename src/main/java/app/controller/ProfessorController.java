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
import org.springframework.web.bind.annotation.RestController;

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
			return new ResponseEntity<>("Deu erro!", HttpStatus.BAD_REQUEST);
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

}
