package es.springboot.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.springboot.application.dao.PersonaDAO;
import es.springboot.application.model.Persona;

@RequestMapping("/persona")
@RestController
public class PersonaController {
	@Autowired
	private PersonaDAO personaDAO;
	
	@GetMapping("/all")
	public List<Persona> getPersonas(){
		return personaDAO.getAll();
	}
	
	@GetMapping("/by-id/{id}")
	public Persona getPersonaById(@PathVariable int id){
		return personaDAO.getById(id);
	}

	@GetMapping("/by-name/{name}")
	public List<Persona> getPersonaById(@PathVariable String name){
		return personaDAO.getByName(name);
	}

	@PostMapping("/save")
	public String savePersona(@RequestBody Persona persona) {
		int registros=0;
		registros = personaDAO.save(persona);
		return "Se han insertado: " + registros + " registros.";
	}
	
	@PutMapping("/update/{id}")
	public String updatePersona(@RequestBody Persona persona,@PathVariable int id) {
		int registros=0;
		registros = personaDAO.update(persona,id);
		return "Se han modificado: " + registros + " registros.";
	}
}
