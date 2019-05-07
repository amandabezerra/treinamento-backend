package com.stefanini.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Campo;
import com.stefanini.projeto.service.CampoService;

@CrossOrigin
@Controller
@RequestMapping(value = "/campo")
public class CampoController {

	@Autowired
	private CampoService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/listar", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Campo>> listar() throws TreinaException {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/consultar/{idCampo}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campo> consultar(@PathVariable(value = "idCampo") Long idCampo) throws TreinaException {
		return new ResponseEntity<>(service.consultar(idCampo), HttpStatus.OK);
	}
    
	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campo> cadastrar(@RequestBody Campo campo) throws TreinaException {
		return new ResponseEntity<>(service.cadastrar(campo), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{idCampo}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluir(@PathVariable(value = "idCampo") Long idCampo) throws TreinaException {
		service.excluir(idCampo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar/{idCampo}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campo> alterar(@PathVariable(value = "idCampo") Long idCampo, 
										@RequestBody Campo campo) throws TreinaException {
		return new ResponseEntity<>(service.alterar(campo, idCampo), HttpStatus.OK);
	}

}