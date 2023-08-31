package es.springboot.application.dao;

import java.util.List;

import es.springboot.application.model.Persona;

public interface PersonaCustomDAO {
	List<Persona> findByName(String name);
}
