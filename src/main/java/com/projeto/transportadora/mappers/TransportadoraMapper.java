package com.projeto.transportadora.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.projeto.transportadora.dto.TransportadoraDTO;
import com.projeto.transportadora.models.Transportadora;

@Mapper(componentModel="spring")
public interface TransportadoraMapper {

	TransportadoraDTO toDto(Transportadora transportadora);
	Transportadora toEntity(TransportadoraDTO transportadoraDto);
	
	List<TransportadoraDTO> toDto(List<Transportadora> transportadoraList);
	List<Transportadora> toEntity(List<TransportadoraDTO> transportadoraDtoList);
	
}
