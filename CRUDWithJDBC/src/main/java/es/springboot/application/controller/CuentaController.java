package es.springboot.application.controller;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.springboot.application.dao.CuentaDAO;
import es.springboot.application.model.Cuenta;

@RequestMapping("/cuenta")
@RestController
public class CuentaController {
	@Autowired
	private CuentaDAO cuentaDAO;

	@PutMapping("/reasign")
	public String reasignaMontoOtraCuenta(@RequestBody String reasignaVal) {
		int registros=0;
		Object obj = JSONValue.parse(reasignaVal);
		JSONObject jsonObject = (JSONObject) obj; 

		Cuenta ctaA =  cuentaDAO.getByNroCta((String) jsonObject.get("nro_cta_a"));
		Cuenta ctaB =  cuentaDAO.getByNroCta((String) jsonObject.get("nro_cta_b"));
		String strmonto = (String) jsonObject.get("monto");  
		
		if(ctaA == null || ctaB == null || strmonto.isEmpty()) {
			return "Revise los parámetros ingresados...";
		}
		else {
			Double monto = Double.parseDouble(strmonto);
			try {
				registros = cuentaDAO.reasignaMontoOtraCuenta(ctaA, ctaB, monto);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//registros = cuentaDAO.reasignaMontoOtraCuenta(ctaA,ctaB,monto);
		return "Se han modificado: " + registros + " registros.";
	}	
}
