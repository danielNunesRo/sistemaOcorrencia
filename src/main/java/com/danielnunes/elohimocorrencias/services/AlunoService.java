package com.danielnunes.elohimocorrencias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielnunes.elohimocorrencias.DTO.AlunoDTO;
import com.danielnunes.elohimocorrencias.domain.Aluno;
import com.danielnunes.elohimocorrencias.repositories.AlunoRepository;
import com.danielnunes.elohimocorrencias.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public List<Aluno> findAll() {
		return repo.findAll();
	}
	
	public Aluno findById(String id) {
	    Optional<Aluno> aluno = repo.findById(id);
	    if (!aluno.isPresent()) {
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return aluno.get();
	}
	
	public Aluno insert(Aluno obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Aluno fromDTO(AlunoDTO objDto) {
		return new Aluno(objDto.getId(), objDto.getNome(), objDto.getTurma());
	}
	
	
}
