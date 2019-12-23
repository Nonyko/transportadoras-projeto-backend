package com.projeto.transportadora.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projeto.transportadora.enums.EstadoEnum;
import com.projeto.transportadora.enums.ModalEnum;

public interface TransportadoraRepositoryCustom {
	Page buscarTransportadoraPorFiltros(Pageable pageable, String nomeTransportadora, List<EstadoEnum> ufList, List<String> municipio, List<ModalEnum> tipoModal);
}
