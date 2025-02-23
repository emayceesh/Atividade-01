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

import app.entity.Turma;
import app.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody Turma turma){

		try {
			String mensagem = this.turmaService.save(turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Turma turma,@PathVariable long id) {

		try {
			String mensagem = this.turmaService.update(turma, id);	
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			String mensagem = this.turmaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/findAll")
	public ResponseEntity <List<Turma>> findAll(){

		try {
			List<Turma> listaTurma = this.turmaService.findAll();
			return new ResponseEntity<>(listaTurma, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity <Turma> findById(long id){


		return null;
	}

}
