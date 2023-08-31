package es.springboot.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.springboot.application.model.Persona;
import es.springboot.application.service.PersonaService;

@RequestMapping("/persona")
@RestController
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/all")
	public List<Persona> getPersonas(){
		return personaService.getAll();
	}
	
	@GetMapping("/by-id/{id}")
	public Persona getPersonaById(@PathVariable int id){
		Persona pers=new Persona();
		try {
			pers = personaService.getById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 	pers;
	}

	@GetMapping("/by-name/{name}")
	public List<Persona> getPersonaById(@PathVariable String name){
		List<Persona> pers=new ArrayList<>();
		try {
			pers = personaService.getByName(name);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 	pers;
	}

	@PostMapping("/save")
	public String savePersona(@RequestBody Persona persona) {
		int registros=0;
		registros = personaService.save(persona);
		return "Se han insertado: " + registros + " registros.";
	}
	
	@PutMapping("/update/{id}")
	public String updatePersona(@RequestBody Persona persona,@PathVariable int id) {
		int registros=0;
		registros = personaService.update(persona,id);
		return "Se han modificado: " + registros + " registros.";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePersona(@PathVariable int id) {
		int registros=0;
		registros = personaService.delete(id);
		return "Se han eliminado: " + registros + " registros.";
	}}