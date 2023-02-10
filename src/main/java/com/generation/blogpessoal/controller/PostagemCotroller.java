package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.PostagemModel;
import com.generation.blogpessoal.repository.PostageRepository;

@RestController
@RequestMapping("/Postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemCotroller {

	@Autowired
	private PostageRepository repository;

	@GetMapping
	public ResponseEntity<List<PostagemModel>>getall() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<PostagemModel> getByID(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<PostagemModel> Post(@Valid @RequestBody PostagemModel postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<PostagemModel> put(@Valid @RequestBody PostagemModel postagem) {
		return repository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delet(@PathVariable Long id) {
		Optional<PostagemModel> postagem = repository.findById(id);

		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		repository.deleteById(id);
	}
}
