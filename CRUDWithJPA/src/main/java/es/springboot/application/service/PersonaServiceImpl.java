package es.springboot.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.springboot.application.dao.PersonaCustomDAO;
import es.springboot.application.dao.PersonaDAO;
import es.springboot.application.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{
	@Autowired
	private PersonaDAO personaDAO;

	@Autowired
	private PersonaCustomDAO personaCustomDAO;

	public List<Persona> getAll(){
		return personaDAO.findAll();
	}

	@Override
	public Persona getById(int id) {
		return personaDAO.getReferenceById(id);
	}

	@Override
	public List<Persona> getByName(String name) {
		List<Persona> pers=new ArrayList<>();
		try {
			pers = personaCustomDAO.findByName(name);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return pers;
	}

	@Override
	public int save(Persona persona) {
		int retVal=0;
		try {
			personaDAO.save(persona);
			retVal++;			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public int update(Persona persona, int id) {
		int retVal=0;
		try {
			Persona pers = new Persona();
			pers.setIdPersona(id);
			pers.setApellido(persona.getApellido());
			pers.setNombre(persona.getNombre());
			pers.setEmail(persona.getEmail());
			pers.setTelefono(persona.getTelefono());			
			personaDAO.save(pers);
			retVal++;			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public int delete(int id) {
		int retVal=0;
		try {
			Persona pers = new Persona();
			pers = personaDAO.getReferenceById(id);
			personaDAO.delete(pers);
			retVal++;			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
