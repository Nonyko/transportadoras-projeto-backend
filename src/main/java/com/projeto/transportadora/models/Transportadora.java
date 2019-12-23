package com.projeto.transportadora.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projeto.transportadora.enums.EstadoEnum;
import com.projeto.transportadora.enums.ModalEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_TRANSPORTADORA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transportadora  implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	
	private String nome;
	private String municipio;	
	@Enumerated(EnumType.STRING)
	private EstadoEnum uf;
	@Enumerated(EnumType.STRING)
	private ModalEnum modal;
}
