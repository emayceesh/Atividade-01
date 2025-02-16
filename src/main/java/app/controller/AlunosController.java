package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Alunos;
import app.service.AlunosService;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {

	@Autowired
	private AlunosService alunosService;

	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody Alunos alunos){

		try {
			String mensagem = this.alunosService.save(alunos);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!", HttpStatus.BAD_REQUEST);
		}	
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Alunos alunos,@PathVariable long id) {

		return "Carro alterado com sucesso";

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.alunosService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(" ", HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/findAll")
	public ResponseEntity <List<Alunos>> findAll(){


		return null;
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity <Alunos> findById(long id){


		return null;
	}

}
