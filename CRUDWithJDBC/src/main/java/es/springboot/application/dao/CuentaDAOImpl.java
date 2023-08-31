package es.springboot.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.springboot.application.model.Cuenta;

@Repository
public class CuentaDAOImpl implements CuentaDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cuenta cuenta, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cuenta> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta getByNroCta(String nroCta) {
		Cuenta cta = new Cuenta();
		cta = jdbcTemplate.queryForObject("select * from test.accounts where nro_cta = ?", new BeanPropertyRowMapper<Cuenta>(Cuenta.class),nroCta);
		return cta;
	}

	@Transactional
	@Override
	public int reasignaMontoOtraCuenta(Cuenta ctaA, Cuenta ctaB, Double monto) {
		int ret = 0;
			
		ret = jdbcTemplate.update("update test.accounts set monto = ? where nro_cta = ?",Double.toString(ctaA.getMonto()-monto),ctaA.getNro_cta());

		//Test para rollback
		//ctaB = null;
		ret += jdbcTemplate.update("update test.accounts set monto = ? where nro_cta = ?",Double.toString(ctaB.getMonto()+monto),ctaB.getNro_cta());
		
		return ret;
	}

}
