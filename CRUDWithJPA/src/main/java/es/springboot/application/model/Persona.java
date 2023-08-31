package es.springboot.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="persona")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_persona")
	private int idPersona;
	
	@Column(name="nombre", length = 45)
	private String nombre;
	
	@Column(name="apellido", length = 45)
	private String apellido;
	
	@Column(name="email", length = 45)
	private String email;
	
	@Column(name="telefono", length = 45)
	private String telefono;
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
