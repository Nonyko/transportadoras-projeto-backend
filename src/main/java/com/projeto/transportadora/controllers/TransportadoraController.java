package com.projeto.transportadora.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

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
	
	/* Endpoint para retornar transportadora	
	 * 
	 * @param idTransportadora
	 * */
	@ApiOperation(value="Endpoint para retornar transportadora", response = TransportadoraDTO.class)
	@GetMapping("/get-transportadora/{idTransportadora}")
	public ResponseEntity<TransportadoraDTO> retornarTransportadora(@PathVariable long idTransportadora){
		Transportadora transportadora = transportadoraService.buscarTransportadora(idTransportadora);
		return new ResponseEntity<TransportadoraDTO>(transportadoraMapper.toDto(transportadora), HttpStatus.OK);
	}
	
	//TODO endpoint para listar transportadoras
	/* Endpoint para listar transportadora	s
	 * 
	 * @param 
	 * */
	@ApiOperation(value="Endpoint para retornar lista de transportadoras", response = TransportadoraDTO[].class)
	@GetMapping("/list-transportadoras/")
	//Decorators para corrigir a paginação no swagger	
	@ApiImplicitParams({
	@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
	@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page.", defaultValue = "5"),
	@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") 
	})
	public ResponseEntity<List<TransportadoraDTO>> listarTransportadoras(
			@ApiIgnore("Ignored because swagger ui shows the wrong params, instead they are explained in the implicit params")
			Pageable pageable)
	{
		Page<Transportadora> transportadoraPage = transportadoraService.listarTransportadoras(pageable);
		
		//Coloca total de paginas no header
		int totalPages = transportadoraPage.getTotalPages();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("totalPages",
		Integer.toString(totalPages));
		
		return ResponseEntity.ok().headers(responseHeaders).body(transportadoraMapper.toDto(transportadoraPage.getContent()));
	}
	
}
