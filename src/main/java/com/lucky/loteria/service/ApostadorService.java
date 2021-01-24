package com.lucky.loteria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucky.loteria.model.Apostador;
import com.lucky.loteria.repository.ApostadorRepository;

@Service
public class ApostadorService {
	
	@Autowired
	private ApostadorRepository repository;
	
	// gerando valores aleatorios para aposta
	public Apostador ApostaRand(Apostador apostador) {
		double vetornum[] = new double[6];
		for(int i=0; i<6; i++) {
			vetornum[i] = Math.random()*100;
		}
		return repository.save(apostador); //salva o objeto apostador com o numero modificado 
	}

}
