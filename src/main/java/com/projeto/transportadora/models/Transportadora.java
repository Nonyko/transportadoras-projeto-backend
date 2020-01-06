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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	//TODO campo logo
	private String nome;
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
	private String cep;	
	
	@ElementCollection(targetClass=ModalEnum.class)	
	@JoinTable(name = "transportadora_modal", joinColumns = @JoinColumn(name = "transportadora_id"))
	@Enumerated(EnumType.STRING)
	private List<ModalEnum> modal;
}
