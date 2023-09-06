package es.springboot.application.dao;

import java.util.List;

import es.springboot.application.model.Persona;

public interface PersonaDAO {
	int save(Persona persona);	
	int update(Persona persona, int id);
	int delete(int id);
	List<Persona> getAll();
	Persona getById(int id);
	List<Persona>getByName(String name);
}
