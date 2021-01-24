package com.lucky.loteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucky.loteria.model.Apostador;
import com.lucky.loteria.repository.ApostadorRepository;
import com.lucky.loteria.service.ApostadorService;

@RestController
@RequestMapping("/loteria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApostadorController {
	
	@Autowired  //injeção das interfaces
	private ApostadorService apostadorService;
	@Autowired 	//injeção das interfaces
	private ApostadorRepository repository;
	
	//Método post para postar uma aposta nova
	@PostMapping
	public ResponseEntity<Apostador> postApostas(@RequestBody Apostador apostador){
		return ResponseEntity.status(HttpStatus.CREATED).body(apostadorService.ApostaRand(apostador));
	}
	//Método get para trazer todas as apostas feitas
	@GetMapping
	public ResponseEntity<List<Apostador>> findAllApostas(){
		return ResponseEntity.ok(repository.findAll());
	}
	//Método get para trazer as apostas feitas pelo email
	@GetMapping("/{email}")
	public ResponseEntity<Apostador> findByApostas(@PathVariable long email){
		return repository.findById(email).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

}
