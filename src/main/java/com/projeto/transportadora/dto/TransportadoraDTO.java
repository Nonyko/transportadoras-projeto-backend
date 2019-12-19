package com.projeto.transportadora.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportadoraDTO {
	private long id;	
	private String nome;
	private String municipio;
	private String uf;
	private String modal;
}
