package com.lucky.loteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucky.loteria.model.Apostador;

public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
	public Optional<Apostador> findByEmail(String apostador);

}
