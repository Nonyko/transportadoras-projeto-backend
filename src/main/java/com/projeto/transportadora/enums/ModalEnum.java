package com.projeto.transportadora.enums;

import lombok.Getter;

@Getter
public enum ModalEnum {
	RODOVIARIO("Rodoviário"),
	AQUAVIARIO("Aquaviário"), 
	AEREO("Aéreo");
	
	private String nome;
	
	ModalEnum(final String nome) {
	    this.nome = nome;
	}
	
	//Retornar Enum por Nome 
	public static ModalEnum fromNome(final String nome) {
	    for (final ModalEnum modal : ModalEnum.values()) {
	      if (modal.nome.equalsIgnoreCase(nome)) {
	        return modal;
	      }
	    }
	    throw new IllegalArgumentException(nome);
	}
	
	
	
}
