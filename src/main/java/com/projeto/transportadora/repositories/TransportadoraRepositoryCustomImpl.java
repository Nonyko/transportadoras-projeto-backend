package com.projeto.transportadora.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;

import com.projeto.transportadora.enums.EstadoEnum;
import com.projeto.transportadora.enums.ModalEnum;
import com.projeto.transportadora.models.Transportadora;

@Repository
public class TransportadoraRepositoryCustomImpl implements TransportadoraRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Page buscarTransportadoraPorFiltros(Pageable pageable, String nomeTransportadora, List<EstadoEnum> ufList, List<String> municipioList, List<ModalEnum> tipoModalList) {
		
		CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
		CriteriaQuery<Transportadora> criteriaQuery   = criteriaBuilder.createQuery(Transportadora.class);
		Root transportadora = criteriaQuery.from(Transportadora.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(nomeTransportadora!=null) {
			predicates.add(criteriaBuilder.like(transportadora.get("nome"), "%"+nomeTransportadora+"%"));
		}
		
		
		if(ufList!=null) {
			final List<Predicate> orPredicatesUF = new ArrayList();
			for(EstadoEnum uf : ufList){
				orPredicatesUF.add(criteriaBuilder.equal( transportadora.get("uf"), uf));
			}
			predicates.add(criteriaBuilder.or(orPredicatesUF.toArray(new Predicate[orPredicatesUF.size()])));
		}
		
		
		
		if(municipioList!=null) {
			final List<Predicate> orPredicatesMunicipio = new ArrayList();
			for(String municipio : municipioList){
				orPredicatesMunicipio.add(criteriaBuilder.equal( transportadora.get("municipio"), municipio));
			}
			predicates.add(criteriaBuilder.or(orPredicatesMunicipio.toArray(new Predicate[orPredicatesMunicipio.size()])));
		}
		
		if(tipoModalList!=null) {
			final List<Predicate> orPredicatesModal = new ArrayList();
			for(ModalEnum modal : tipoModalList){
				orPredicatesModal.add(criteriaBuilder.equal( transportadora.get("modal"), modal));
			}
			predicates.add(criteriaBuilder.or(orPredicatesModal.toArray(new Predicate[orPredicatesModal.size()])));
		}

		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(QueryUtils.toOrders(pageable.getSort(), transportadora, criteriaBuilder));
		
		TypedQuery query = entityManager.createQuery(criteriaQuery);

		int totalRows = query.getResultList().size();

		  query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		  query.setMaxResults(pageable.getPageSize());
	
		  Page result = new PageImpl(query.getResultList(), pageable, totalRows);
	
		  return result;
	}

}
