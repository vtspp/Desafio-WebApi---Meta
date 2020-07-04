package com.desafio.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafio.api.model.Contato;
import com.desafio.api.service.ContatoService;

@Controller
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;
	
	@GetMapping("/buscarId/{idContato}")
	public ResponseEntity<Optional<Contato>> buscarContatoById(@PathVariable("idContato") Integer idContato) {
		return ResponseEntity.ok().body(contatoService.buscarContatoById(idContato));
	}
		
	@GetMapping("/listar")
	public ResponseEntity<Page<Contato>> listaContato(@PageableDefault(value = 10) Pageable pageable){
		return ResponseEntity.ok().body(contatoService.listaContato(pageable));
	}
	
	@PutMapping("/atualizar/{idContato}")
	public ResponseEntity<ResponseEntity<Contato>> alterarContatoById(@RequestBody Contato contato, @PathVariable ("idContato") Integer idContato) {
		return ResponseEntity.ok().body(contatoService.alterarContato(contato, idContato));
	}
	
	@DeleteMapping("/apagarById/{idContato}")
	public void apagarContatoById(@PathVariable("idContato") Integer idContato) {
		 contatoService.apagarContato(idContato);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Contato> novoContato (@RequestBody Contato contato) {
		return ResponseEntity.ok().body(contatoService.novoContato(contato));
	}
	
	

}