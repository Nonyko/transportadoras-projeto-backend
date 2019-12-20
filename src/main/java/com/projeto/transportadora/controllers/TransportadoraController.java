package com.projeto.transportadora.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.transportadora.dto.CriarTransportadoraDTO;
import com.projeto.transportadora.dto.TransportadoraDTO;
import com.projeto.transportadora.mappers.TransportadoraMapper;
import com.projeto.transportadora.models.Transportadora;
import com.projeto.transportadora.services.TransportadoraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/transportadoras")
@Api(value="API REST Transportadoras")
@CrossOrigin(origins = "*")
public class TransportadoraController {

	TransportadoraService transportadoraService;
	TransportadoraMapper transportadoraMapper;
	
	public TransportadoraController(TransportadoraService transportadoraService, TransportadoraMapper transportadoraMapper) {
		this.transportadoraService = transportadoraService;
		this.transportadoraMapper = transportadoraMapper;
	}
	
	
	/* Endpoint para criar transportadora	
	 * 
	 * @param criarTransportadoraDTO
	 * @return  ResponseEntity<TransportadoraDTO>
	 * */
	@ApiOperation(value="Endpoint para criar transportadora", response = TransportadoraDTO.class)
	@PostMapping("/criar")
	public ResponseEntity<TransportadoraDTO> criarTransportadora(@RequestBody CriarTransportadoraDTO criarTransportadoraDTO){
		Transportadora transportadoraCriada = transportadoraService.criarTransportadora(criarTransportadoraDTO);
		return new ResponseEntity<TransportadoraDTO>(transportadoraMapper.toDto(transportadoraCriada), HttpStatus.OK);
	}
	
	/* Endpoint para editar transportadora	
	 * 
	 * @param criarTransportadoraDTO
	 * @param idTransportadora
	 * @return  ResponseEntity<TransportadoraDTO>
	 * */
	@ApiOperation(value="Endpoint para editar transportadora", response = TransportadoraDTO.class)
	@PutMapping("/editar/{idTransportadora}")
	public ResponseEntity<TransportadoraDTO> editarTransportadora(	@PathVariable long idTransportadora, 
																	@RequestBody CriarTransportadoraDTO criarTransportadoraDTO){
		Transportadora transportadoraEditada = transportadoraService.editarTransportadora(criarTransportadoraDTO, idTransportadora);
		return new ResponseEntity<TransportadoraDTO>(transportadoraMapper.toDto(transportadoraEditada), HttpStatus.OK);
	}
	
	//TODO endpoint para deletar transportadora
	/* Endpoint para deletar transportadora	
	 * 
	 * @param idTransportadora
	 * */
	@ApiOperation(value="Endpoint para deletar transportadora", response = TransportadoraDTO.class)
	@DeleteMapping("/deletar/{idTransportadora}")
	public ResponseEntity<TransportadoraDTO> deletarTransportadora(	@PathVariable long idTransportadora){
		Transportadora transportadoraDeletada = transportadoraService.deletarTransportadora(idTransportadora);
		return new ResponseEntity<TransportadoraDTO>(transportadoraMapper.toDto(transportadoraDeletada), HttpStatus.OK);
	}
	
	//TODO endpoint para listar transportadoras
	
}
