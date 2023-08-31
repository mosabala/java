package es.springboot.application.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.springboot.application.model.Persona;

@Transactional
@Repository
public interface PersonaDAO extends JpaRepository<Persona, Integer>{
/*	int save(Persona persona);	
	int update(Persona persona, int id);
	int delete(int id);
	List<Persona> getAll();
	Persona getById(int id);
	List<Persona>getByName(String name);*/
}
