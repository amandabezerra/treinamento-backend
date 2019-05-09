package com.stefanini.projeto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Campo;
import com.stefanini.projeto.model.Linha;
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
		validaTamanhoNome(campo);
		validaNumeroDeLinhas(campo);
		validaNomeUnico(campo);
		
		if (campo.getLinhas() != null) {
			for (Linha linha : campo.getLinhas()) {
				linha.setCampo(campo);
			}
		}
		
		return repository.save(campo);
	}
	
	public void excluir(Long id) throws TreinaException {
		repository.deleteById(id);
	}
	
	public Campo alterar(Campo campo, Long id) throws TreinaException {
		validaTamanhoNome(campo);
		validaNumeroDeLinhas(campo);
		validaNomeUnico(campo);
		
		Campo campoAlterado = (Campo) repository.findById(id).get();
		campoAlterado.setNome(campo.getNome());
		
		if (campo.getLinhas() != null) {
			for (Linha linha : campo.getLinhas()) {
				campoAlterado.adicionaLinha(linha);
			}
		}
		
		return repository.save(campoAlterado);
	}
	
	private void validaNumeroDeLinhas(Campo campo) throws TreinaException {
		if (campo.getLinhas() != null && campo.getLinhas().size() > 5) {
			throw new TreinaException("Campo não pode ter mais de 5 linhas.");
		}
	}

	private void validaTamanhoNome(Campo campo) throws TreinaException {
		if (campo.getNome().length() > 20) {
			throw new TreinaException("Tamanho de 'nome' não pode ultrapassar 20 caracteres.");
		}
	}
	
	private void validaNomeUnico(Campo campo) throws TreinaException {
		boolean nomeExiste = false;
		for (Campo c : listar()) {
			if (c.getNome() == campo.getNome()) {
				nomeExiste = true;
				break;
			}
		}
		if (nomeExiste) {
			throw new TreinaException("Já existe um entidade Campo com esse nome.");
		}
	}

}