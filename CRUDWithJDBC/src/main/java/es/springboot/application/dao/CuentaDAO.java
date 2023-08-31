package es.springboot.application.dao;

import java.util.List;

import es.springboot.application.model.Cuenta;


public interface CuentaDAO {
	int save(Cuenta cuenta);	
	int update(Cuenta cuenta, int id);
	int delete(int id);
	List<Cuenta> getAll();
	Cuenta getById(int id);
	Cuenta getByNroCta(String nroCta);
	int reasignaMontoOtraCuenta(Cuenta ctaA,Cuenta ctaB, Double monto);
}




