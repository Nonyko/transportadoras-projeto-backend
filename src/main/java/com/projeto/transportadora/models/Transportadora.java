package com.projeto.transportadora.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
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
	
	//TODO logo
	
	private String nome;//required
	private String email;
	private String empresa;
	private String telefone;
	private String celular;
	private String whatsapp;
	
	private String municipio;	
	private String bairro;
	private String rua;
	private String numero;	
	@Enumerated(EnumType.STRING)
	private EstadoEnum uf;
	
	@ElementCollection(targetClass=ModalEnum.class)
	@CollectionTable(name="transportadora_modal")
	@Enumerated(EnumType.STRING)
	private List<ModalEnum> modal;
}
