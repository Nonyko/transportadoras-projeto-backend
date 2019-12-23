package com.projeto.transportadora.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.projeto.transportadora.enums.ModalEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarTransportadoraDTO {
	@NotEmpty(message = "Campo nome deve ser preenchido.")
	@Size(min=4, message="Nome da empresa deve ter pelo menos 2 caracteres")
	private String nome;
	@NotEmpty(message = "Campo email deve ser preenchido.")
	@Email(message = "Campo email deve conter email valido.")
	private String email;
	@NotEmpty(message = "Campo empresa deve ser preenchido.")
	private String empresa;
	@NotEmpty(message = "Campo telefone deve ser preenchido.")
	private String telefone;
	private String celular;
	private String whatsapp;
	@NotEmpty(message = "Campo bairro deve ser preenchido.")
	private String bairro;
	@NotEmpty(message = "Campo rua deve ser preenchido.")
	private String rua;
	@NotEmpty(message = "Campo numero deve ser preenchido.")
	private String numero;	
	@NotEmpty(message = "Campo municipio deve ser preenchido.")
	private String municipio;
	@NotEmpty(message = "Campo uf deve ser preenchido.")
	private String uf;
	@NotNull(message = "Campo uf deve ser preenchido.")
	private List<ModalEnum> modal;
}
