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

import com.projeto.transportadora.models.Transportadora;

@Repository
public class TransportadoraRepositoryCustomImpl implements TransportadoraRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Page buscarTransportadoraPorFiltros(Pageable pageable, String nomeTransportadora) {
		
		CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
		CriteriaQuery<Transportadora> criteriaQuery   = criteriaBuilder.createQuery(Transportadora.class);
		Root transportadora = criteriaQuery.from(Transportadora.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(nomeTransportadora!=null) {
			predicates.add(criteriaBuilder.like(transportadora.get("nome"), "%"+nomeTransportadora+"%"));
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
