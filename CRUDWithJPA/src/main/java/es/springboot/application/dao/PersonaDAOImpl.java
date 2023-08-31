package es.springboot.application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import es.springboot.application.model.Persona;

public class PersonaDAOImpl implements PersonaCustomDAO{
	@Autowired 
	EntityManager entityManager;
	
	@Override
	public List<Persona> findByName(String name) {
	    
		//Hay tres formas de obtener los datos
		//1) Por Criteria
		//criteriaQuery.where(criteriaBuilder.greaterThan(persona.get("sueldo"), 100000));
	    
		
		//2) Por Predicate
		//Predicate predicate1 = cb.equal(pet.get(Pet_.name), "Fido");
		//cq.where(predicate1.and(predicate2));
		
		//3) To be able to define reusable Predicates we introduced the Specification interface
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
		Root<Persona> pers = criteria.from(Persona.class);
		List<Predicate> predicados = new ArrayList<Predicate>();
		Predicate predicateNombre = builder.like(pers.get("nombre"), "%" + name.toUpperCase() + "%");
		Predicate predicateApellido = builder.like(pers.get("apellido"), "%"  + name.toUpperCase() + "%");
		
		predicados.add(builder.or(predicateNombre,predicateApellido));
		//predicados.add(builder.equal(pers.get("activo"), activo));
		criteria.select(pers);
		criteria.where(builder.and(predicados.toArray(new Predicate[predicados.size()])));

		return entityManager.createQuery(criteria).getResultList();	
	}

}
