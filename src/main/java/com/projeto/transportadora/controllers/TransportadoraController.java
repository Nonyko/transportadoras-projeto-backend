package com.projeto.transportadora.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//TODO endpoint para criar transportadora	
	@ApiOperation(value="Retorna uma lista de character", response = TransportadoraDTO.class)
	@PostMapping("/criar")
	public ResponseEntity<TransportadoraDTO> criarTransportadora(@RequestBody CriarTransportadoraDTO criarTransportadoraDTO){
		Transportadora transportadoraCriada = transportadoraService.criarTransportadora(criarTransportadoraDTO);
		return new ResponseEntity<TransportadoraDTO>(transportadoraMapper.toDto(transportadoraCriada), HttpStatus.OK);
	}
	
	
	//TODO endpoint para editar transportadora
	
	//TODO endpoint para deletar transportadora
	
	//TODO endpoint para listar transportadoras
	
}
