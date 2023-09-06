package es.springboot.application.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.springboot.application.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Persona persona) {
		int ret = 0;
		try {
			ret = jdbcTemplate.update("insert into test.persona(nombre,apellido,email,telefono) values (?,?,?,?)",new Object[] {persona.getNombre(),persona.getApellido(),persona.getEmail(),persona.getTelefono()});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ret;
	}

	@Override
	public int update(Persona persona, int id) {
		int ret = 0;
		try {
			ret = jdbcTemplate.update("update test.persona set nombre = ?,apellido=?,email=?,telefono = ? where id_persona = ?",new Object[] {persona.getNombre(),persona.getApellido(),persona.getEmail(),persona.getTelefono(),id});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ret;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Persona> getAll() {
		return jdbcTemplate.query("select * from test.persona", new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Override
	public Persona getById(int id) {
		return jdbcTemplate.queryForObject("select * from test.persona where id_persona = ?", new BeanPropertyRowMapper<Persona>(Persona.class),id);
	}

	@Override
	public List<Persona> getByName(String nameParam) {
		List<Persona> lstPers=new ArrayList<Persona>();
		try {
			String queryParam = "select * from test.persona where ucase(nombre) like ? or ucase(apellido) like ?";
			String finalName= "%" + nameParam.toUpperCase().trim() + "%";

			//MapSqlParameterSource namedParams= new MapSqlParameterSource();
			//namedParams.addValue("pname", finalName);
			
			
			lstPers = jdbcTemplate.query(queryParam, new BeanPropertyRowMapper<Persona>(Persona.class),finalName,finalName);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lstPers;
	}

}
