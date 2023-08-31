package com.projetocadastroaluno.repository;

import org.springframework.data.repository.CrudRepository;

import com.projetocadastroaluno.model.Aluno;

public interface AlunoRepositorio extends CrudRepository<Aluno, Long> {
	
	Aluno findByMatricula(Long matricula);
}
