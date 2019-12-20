package com.projeto.transportadora.enums;

import lombok.Getter;

@Getter
public enum EstadoEnum {
	AC("Acre", "AC"),
	AL("Alagoas", "AL"), 
	AM("Amazonas", "AM"), 		
	AP("Amapá", "AP"), 
	BA("Bahia", "BA"), 
	CE("Ceará", "CE"), 
	DF("Distrito Federal", "DF"),
	ES("Espírito Santo", "ES"),
	GO("Goiás", "GO"),
	MA("Maranhão", "MA"), 
	MG("Minas Gerais", "MG"),
	MT("Mato Grosso", "MT"), 	
	MS("Mato Grosso do Sul", "MS"), 
	PA("Pará", "PA"),	
	PB("Paraíba", "PB"),
	PE("Pernambuco", "PE"),
	PI("Piauí", "PI"), 
	PR("Paraná", "PR"), 	
	RJ("Rio de Janeiro", "RJ"),
	RN("Rio Grande do Norte", "RN"), 
	RO("Rondônia", "RO"), 
	RR("Roraima", "RR"),
	RS("Rio Grande do Sul", "RS"),	
	SC("Santa Catarina", "SC"), 
	SE("Sergipe", "SE"),
	SP("São Paulo", "SP"),
	TO("Tocantins", "TO");	
	
	private String nome;
	private String sigla;
	
	EstadoEnum(final String nome, final String sigla) {
	    this.nome = nome;
	    this.sigla = sigla;
	}
	
	//Retornar Enum por Nome Estado
	public static EstadoEnum fromNomeEstado(final String nomeEstado) {
	    for (final EstadoEnum uf : EstadoEnum.values()) {
	      if (uf.nome.equalsIgnoreCase(nomeEstado)) {
	        return uf;
	      }
	    }
	    throw new IllegalArgumentException(nomeEstado);
	}
	
	//Retornar Enum por sigla do Estado
	public static EstadoEnum fromSigla(final String sigla) {
	    for (final EstadoEnum uf : EstadoEnum.values()) {
	      if (uf.sigla.equalsIgnoreCase(sigla)) {
	        return uf;
	      }
	    }
	    throw new IllegalArgumentException(sigla);
	  }
	
	@Override
	public String toString() {		
		return sigla;
	  }
}
