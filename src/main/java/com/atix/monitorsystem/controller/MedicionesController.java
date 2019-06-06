package com.atix.monitorsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atix.monitorsystem.domain.Medicion;
import com.atix.monitorsystem.service.MedicionesService;

@RestController
public class MedicionesController {
	
	@Autowired
	private MedicionesService ms; 
	
	@RequestMapping(value="/mediciones", method=RequestMethod.POST)
	public void crearMedicion(@RequestBody Medicion medicion){
		ms.crearNuevaMedicion(medicion);
		System.out.println("Creo la medicion valor: " + medicion.getValor());
	}

}