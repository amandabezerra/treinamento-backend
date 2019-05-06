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
	
	public List<Campo> listar() throws TreinaException {
		return (List<Campo>) repository.findAll();
	}

	public Campo consultar(Long id) throws TreinaException {
		return repository.findById(id).get();
	}
	
	public Campo cadastrar(Campo campo) throws TreinaException {
		return repository.save(campo);
	}
	
	public void excluir(Long id) throws TreinaException {
		repository.deleteById(id);
	}
	
	public Campo alterar(Campo campo, Long id) throws TreinaException {
		Campo campoAlterado = (Campo) repository.findById(id).get();
		campoAlterado.setNome(campo.getNome());
		
		return repository.save(campoAlterado);
	}

}