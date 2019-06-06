package com.atix.monitorsystem.service;

import com.atix.monitorsystem.domain.Medicion;

public interface MedicionesService {
	
	void crearNuevaMedicion(Medicion medicion);
	
	void validarDiferenciaMinMax() throws Exception; 
	
	void validarPromedio(Integer valorTotal, Integer cantidad) throws Exception;
	
}