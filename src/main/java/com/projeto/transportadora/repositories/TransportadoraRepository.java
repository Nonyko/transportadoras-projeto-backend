package com.projeto.transportadora.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.transportadora.models.Transportadora;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {

	Page findAll(Pageable pageable);
}
