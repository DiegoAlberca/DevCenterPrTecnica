package es.dev.center.prueba.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.dev.center.prueba.dao.PrecioDAO;
import es.dev.center.prueba.dao.PrecioDAOCustom;
import es.dev.center.prueba.model.Precio;

public class PrecioDAOImpl implements PrecioDAOCustom {

    @PersistenceContext
    public EntityManager em;

	@Override
	public Precio findByCocheFecha(Long coche, Date fecha) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Precio> criteriaQuery = cb.createQuery(Precio.class);
		Root<Precio> root = criteriaQuery.from(Precio.class);
		ParameterExpression<Long> p = cb.parameter(Long.class);
		
		//Filtro para el ID del coche
		criteriaQuery.select(root).where(cb.equal(root.get("coche.id"), p));
		
		//Se añaden los filtros para comprobar que la fecha pasada por parametro se encuentra entre los campos de BBDD
		List<Predicate> conditionsList = new ArrayList<Predicate>();
		Predicate onStart = cb.greaterThanOrEqualTo(root.get("fechaInicio"), fecha);
		Predicate onEnd = cb.lessThanOrEqualTo(root.get("fechaFin"), fecha);
		conditionsList.add(onStart);
		conditionsList.add(onEnd);
		criteriaQuery.select(root).where(conditionsList.toArray(new Predicate[]{}));
		
		TypedQuery<Precio> query = em.createQuery(criteriaQuery);
		query.setParameter(p, coche);
		return query.getSingleResult();
	}

}
