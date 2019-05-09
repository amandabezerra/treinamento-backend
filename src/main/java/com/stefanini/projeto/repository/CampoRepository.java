package com.stefanini.projeto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stefanini.projeto.model.Campo;

public interface CampoRepository extends CrudRepository<Campo, Long>{
	List<Campo> findByNome(String nome);
	List<Campo> findByNomeContainingIgnoreCase(String nome);
}
