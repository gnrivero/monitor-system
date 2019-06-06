package com.atix.monitorsystem.repository;

import com.atix.monitorsystem.domain.Medicion;

public interface MedicionesRepository {
	
	public void add(Medicion m);
		
	public Medicion poll();
	
	public boolean isEmpty();

}