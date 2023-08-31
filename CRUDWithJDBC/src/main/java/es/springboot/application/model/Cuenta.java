package es.springboot.application.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
	private int idaccount;
	private String nro_cta;
	private int idPersona;
	private double monto;
}
