package com.atix.monitorsystem.repository;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Component;
import com.atix.monitorsystem.domain.Medicion;


@Component
public class MedicionesRepositoryImpl implements MedicionesRepository {
	
	private ConcurrentLinkedQueue<Medicion> medicionesQueue = new ConcurrentLinkedQueue<>();
	
	public void add(Medicion m) {
		medicionesQueue.add(m);
	}
		
	public Medicion poll() {
		return medicionesQueue.poll();
	}
	
	public void probandoGetCosas() {
		
		Iterator<Medicion> iterator = medicionesQueue.iterator();
		
		while ( iterator.hasNext() ) {
			iterator.next();
		}
		
	}

	@Override
	public boolean isEmpty() {
		return medicionesQueue.isEmpty();
	}

}