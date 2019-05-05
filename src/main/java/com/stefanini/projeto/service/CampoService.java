package com.stefanini.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Campo;
import com.stefanini.projeto.repository.CampoRepository;

@Service
public class CampoService {

	@Autowired
	private CampoRepository repository;
	
	public List<Campo> findAll() throws TreinaException {
		return (List<Campo>) repository.findAll();
	}

}