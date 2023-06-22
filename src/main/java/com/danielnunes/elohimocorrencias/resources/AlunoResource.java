package com.danielnunes.elohimocorrencias.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.danielnunes.elohimocorrencias.DTO.AlunoDTO;
import com.danielnunes.elohimocorrencias.domain.Aluno;
import com.danielnunes.elohimocorrencias.domain.Ocorrencia;
import com.danielnunes.elohimocorrencias.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<Aluno> list = service.findAll();
		List<AlunoDTO> listDto = list.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable String id) {
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(new AlunoDTO(obj));
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AlunoDTO objDto) {
		Aluno obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping(value="/{id}/ocorrencias")
	public ResponseEntity<List<Ocorrencia>> findPosts(@PathVariable String id) {
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getOcorrencias());
		
	}
	
	
}
