package com.danielnunes.elohimocorrencias.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danielnunes.elohimocorrencias.domain.Aluno;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
