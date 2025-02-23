package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import app.service.AlunosService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/alunos")
public class AlunosController {

	@Autowired
	private AlunosService alunosService;

	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody @Valid Alunos alunos, BindingResult result){

		try {
			String mensagem = this.alunosService.save(alunos);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!", HttpStatus.BAD_REQUEST);
		}	
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Alunos alunos,@PathVariable long id) {

		try {
			String mensagem = this.alunosService.update(alunos, id);	
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}

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

		try {
			List<Alunos> listaAlunos = this.alunosService.findAll();
			return new ResponseEntity<>(listaAlunos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity <Alunos> findById(long id){


		return null;
	}

	@GetMapping("/findByNome")
	public ResponseEntity<List<Alunos>> findByNomeCompletoStartingWith(@RequestParam String nome) {
		
		try {
			List<Alunos> lista = this.alunosService.findByNomeCompleto(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findByTelefone")
	public ResponseEntity<List<Alunos>> findByTelefoneContaining(@RequestParam String telefone) {
		try {
			List<Alunos> lista = this.alunosService.findByTelefone(telefone); 
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("/findByNomeTurma")
	public ResponseEntity<List<Alunos>> findByNomeTurma(@RequestParam String nomeTurma) {
		
		try {
			List<Alunos> lista = this.alunosService.findByNomeTurma(nomeTurma);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
