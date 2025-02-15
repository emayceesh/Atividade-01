package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
