package com.projeto.transportadora.dto;

import com.projeto.transportadora.enums.EstadoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportadoraDTO {
	private long id;	
	private String nome;
	private String municipio;
	private EstadoEnum uf;
	private String modal;
}
