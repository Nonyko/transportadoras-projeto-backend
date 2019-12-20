
package com.projeto.transportadora.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.transportadora.dto.CriarTransportadoraDTO;
import com.projeto.transportadora.enums.EstadoEnum;
import com.projeto.transportadora.models.Transportadora;
import com.projeto.transportadora.repositories.TransportadoraRepository;

import javassist.NotFoundException;

@Service
public class TransportadoraService {
	
	private TransportadoraRepository transportadoraRepository;
	
	public TransportadoraService(TransportadoraRepository transportadoraRepository) {
		this.transportadoraRepository = transportadoraRepository;
	}

	/**
	 * Serviço para criar transportadora a partir de um DTO passado como parametro.
	 * 
	 * @param criarTransportadoraDTO
	 * @return transportadora 
	 */
	public Transportadora criarTransportadora(CriarTransportadoraDTO criarTransportadoraDTO) {
		
		Transportadora novaTransportadora = new Transportadora();
		novaTransportadora.setNome(criarTransportadoraDTO.getNome());
		novaTransportadora.setModal(criarTransportadoraDTO.getMunicipio());
		novaTransportadora.setMunicipio(criarTransportadoraDTO.getMunicipio());
		novaTransportadora.setUf(EstadoEnum.fromSigla(criarTransportadoraDTO.getUf()));
		
		this.transportadoraRepository.save(novaTransportadora);
		
		return novaTransportadora;
	}
	
	/**
	 * Serviço para editar transportadora a partir de um DTO passado como parametro e um id de transportadora.
	 * 
	 * @param criarTransportadoraDTO
	 * @param idTransportadora
	 * @return transportadora 
	 */
	public Transportadora editarTransportadora(CriarTransportadoraDTO criarTransportadoraDTO, long idTransportadora) {
		
		Transportadora transportadoraEditada = new Transportadora();
		Optional<Transportadora> transportadoraParaEditar = this.transportadoraRepository.findById(idTransportadora);
		if(transportadoraParaEditar.isPresent()) {
			transportadoraEditada = transportadoraParaEditar.get();
			transportadoraEditada.setNome(criarTransportadoraDTO.getNome());
			transportadoraEditada.setModal(criarTransportadoraDTO.getMunicipio());
			transportadoraEditada.setMunicipio(criarTransportadoraDTO.getMunicipio());
			transportadoraEditada.setUf(EstadoEnum.fromSigla(criarTransportadoraDTO.getUf()));
			this.transportadoraRepository.save(transportadoraEditada);
		}else {
		String msg = "Transportadora não encontrada para o id passado.";
		throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, msg, new NotFoundException(msg));
		}	
		
		return transportadoraEditada;
	}
	
	/**
	 * Serviço para deletar transportadora a partir de um id de transportadora.
	 * 
	 * @param idTransportadora
	 * @return transportadora 
	 */
	public Transportadora deletarTransportadora(long idTransportadora) {
		
		Transportadora transportadoraDeletada = new Transportadora();
		Optional<Transportadora> transportadora = this.transportadoraRepository.findById(idTransportadora);
		if(transportadora.isPresent()) {
			transportadoraDeletada = transportadora.get();
			this.transportadoraRepository.delete(transportadoraDeletada);
		}else {
		String msg = "Transportadora não encontrada para o id passado.";
		throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, msg, new NotFoundException(msg));
		}	
		
		return transportadoraDeletada;
	}
	
	/**
	 * Serviço para listar transportadora a partir de um conjunto de filtros
	 * 
	 * @param pageable
	 * @return transportadorasPage 
	 */
	public Page listarTransportadoras(Pageable pageable) {
		//TODO listar transportadoras por filtro
		Page transportadorasPage = this.transportadoraRepository.findAll(pageable);
		return transportadorasPage;
	}
}