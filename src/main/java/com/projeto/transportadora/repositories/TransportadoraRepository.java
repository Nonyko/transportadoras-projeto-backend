package com.projeto.transportadora.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.transportadora.models.Transportadora;
import com.projeto.transportadora.repositories.interfaces.MunicipioCount;
import com.projeto.transportadora.repositories.interfaces.UfCount;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>, TransportadoraRepositoryCustom {

	Page findAll(Pageable pageable);
	
	 @Query("select t.uf as uf, count(t.uf) as ufCount from Transportadora t group by t.uf")
	 List<UfCount> getUfSAndUfSCount();
	 
	 @Query("select t.municipio as municipio, count(t.municipio) as municipioCount from Transportadora t group by t.municipio")
	 List<MunicipioCount> getMunicipiosAndMunicipiosCount();
	
	
}
