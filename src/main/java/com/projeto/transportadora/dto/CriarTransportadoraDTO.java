package com.projeto.transportadora.dto;

import java.util.List;

import com.projeto.transportadora.enums.ModalEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarTransportadoraDTO {
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
	private String uf;
	private List<ModalEnum> modal;
}
