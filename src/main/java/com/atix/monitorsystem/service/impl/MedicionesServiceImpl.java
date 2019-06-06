package com.atix.monitorsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.atix.monitorsystem.domain.Medicion;
import com.atix.monitorsystem.repository.MedicionesRepository;
import com.atix.monitorsystem.service.MedicionesService;

@Service
public class MedicionesServiceImpl implements MedicionesService {
	
	private static Medicion min = new Medicion(101); 
	private static Medicion max = new Medicion(0); 
	
	@Value("${minimomaximo}")
	private Integer S;
	@Value("${promedio}")
	private Integer M;
	
	@Autowired
	private MedicionesRepository repo;
	
	@Override
	public void crearNuevaMedicion(Medicion medicion) {
		repo.add(medicion);
	}

	@Override
	public void validarDiferenciaMinMax() throws Exception {	
		Integer diferencia = max.getValor() - min.getValor();
		
		if (diferencia > S)
			throw new Exception("Difrencia entre Min y Max superada");
	}

	@Override
	public void validarPromedio(Integer valorTotal, Integer cantidad) throws Exception {
		
		Integer promedio = valorTotal / cantidad;
				
		if (promedio > M)
			throw new Exception("Promedio superado");
	}
	
	@Scheduled(fixedRate=30000)
	public void alertCheckProcess() {
		
		if (repo.isEmpty())
			throw new RuntimeException("La cola mediciones está vacia");
		
		int chunkSize = 100;
		
		Integer valoresTotales = 0;
		Medicion medicion = null;
		for (int i = 0; i < chunkSize; i++) {
			medicion = repo.poll();
			
			if(medicion == null)
				break;
			
			if (medicion.getValor() < min.getValor())
				min = medicion;
			
			if (medicion.getValor() > max.getValor())
				max = medicion;
			
			valoresTotales += medicion.getValor();
		}
		
		try {
			validarDiferenciaMinMax();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			validarPromedio(valoresTotales, chunkSize);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}