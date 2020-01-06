package com.projeto.transportadora.dto;

import java.util.List;

import com.projeto.transportadora.enums.EstadoEnum;
import com.projeto.transportadora.enums.ModalEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportadoraDTO {
	private long id;	
	private String nome;
	private String email;
	private String empresa;
	private String telefone;
	private String celular;
	private String whatsapp;
	private String bairro;
	private String rua;
	private String numero;	
	private String municipio;
	private EstadoEnum uf;
	private List<ModalEnum> modal;
	private String cep;
}
