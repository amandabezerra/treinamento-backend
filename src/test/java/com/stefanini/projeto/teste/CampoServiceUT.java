//package com.stefanini.projeto.teste;
//
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.stefanini.projeto.exception.TreinaException;
//import com.stefanini.projeto.model.Campo;
//import com.stefanini.projeto.model.Linha;
//import com.stefanini.projeto.repository.CampoRepository;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CampoServiceUT {
//
//	@Mock
//	private CampoRepository repository;
//	
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
////		service.setRepo
//	}
//	
//	@Test
//	public List<Campo> listar() throws TreinaException {
//		assertNotNull(service.findAll("teste"));
//		return (List<Campo>) repository.findAll();
//	}
//
//	public Campo consultar(Long id) throws TreinaException {
//		return repository.findById(id).get();
//	}
//	
//	public Campo cadastrar(Campo campo) throws TreinaException {		
//		if (campo.getLinhas() != null) {
//			for (Linha linha : campo.getLinhas()) {
//				linha.setCampo(campo);
//			}
//		}
//		
//		return repository.save(campo);
//	}
//	
//	public void excluir(Long id) throws TreinaException {
//		repository.deleteById(id);
//	}
//	
//	public Campo alterar(Campo campo, Long id) throws TreinaException {
//		Campo campoAlterado = (Campo) repository.findById(id).get();
//		campoAlterado.setNome(campo.getNome());
//		
//		if (campo.getLinhas() != null) {
//			for (Linha linha : campo.getLinhas()) {
//				campoAlterado.adicionaLinha(linha);
//			}
//		}
//		
//		return repository.save(campoAlterado);
//	}
//
//}