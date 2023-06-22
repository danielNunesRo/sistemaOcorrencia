package com.danielnunes.elohimocorrencias.config;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danielnunes.elohimocorrencias.domain.Aluno;
import com.danielnunes.elohimocorrencias.domain.Ocorrencia;
import com.danielnunes.elohimocorrencias.repositories.AlunoRepository;
import com.danielnunes.elohimocorrencias.repositories.OcorrenciaRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
	}

}
