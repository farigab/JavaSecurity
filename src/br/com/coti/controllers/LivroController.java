package br.com.coti.controllers;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.coti.entity.Livro;
import br.com.coti.repository.LivroRepository;

@RestController
@CrossOrigin
public class LivroController {
	
	@Autowired
	LivroRepository livrodao;
	
	@GetMapping("/livro")
	public List<Livro> findAll(){
		return livrodao.findAll();
	}
	
	@GetMapping("/livro/{id}")
	public Livro findByCode(@PathVariable @Min(1) Long id){
		return livrodao.findById(id).orElseThrow(()-> new IllegalArgumentException("Livro nao encontrado"));
	}
	
	@PostMapping(value="/livro")
	public Livro newLivro(@RequestBody Livro livro) {
		return livrodao.save(livro);
	}
	
	@PutMapping(value="/livro/{id}")
	public ResponseEntity<?> update(@PathVariable @Min(1) Long id,
			@RequestBody Livro livro
	){
		try {
			Livro li = livrodao.findById(id).get();
			if(li==null) throw new Exception("Livro nao Encontrado");
			li.setNome(livro.getNome());
			li.setPreco(livro.getPreco());
			
			Livro resposta = livrodao.save(li);
			
			
			return new ResponseEntity<>(resposta, HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>("Dados Invalidos, error:" + ex.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping(value="/livro/{id}")
	public ResponseEntity<?> delete(@PathVariable @Min(1) Long id){
		try {
			Livro li = livrodao.findById(id).get();
			if(li==null) throw new Exception("Livro nao Encontrado");
			livrodao.delete(li);
									
			return new ResponseEntity<>("Excluido", HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>("Nao encontrado, error:" + ex.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
