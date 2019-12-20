package com.projeto.transportadora.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransportadoraRepositoryCustom {
	Page buscarTransportadoraPorFiltros(Pageable pageable, String nomeTransportadora);
}
