package es.springboot.application.service;

import java.util.List;

import es.springboot.application.model.Persona;

public interface PersonaService {
	public List<Persona> getAll();
	public Persona getById(int id);
	List<Persona>getByName(String name);
	int save(Persona persona);	
	int update(Persona persona, int id);
	int delete(int id);
}
