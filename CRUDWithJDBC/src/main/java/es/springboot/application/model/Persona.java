package es.springboot.application.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	private int idPersona;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
}
