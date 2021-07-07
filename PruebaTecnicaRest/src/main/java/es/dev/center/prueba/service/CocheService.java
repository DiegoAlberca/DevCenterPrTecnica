package es.dev.center.prueba.service;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import es.dev.center.prueba.model.Coche;

public interface CocheService {
	
	public Iterable<Coche> findAll();
	
	public Optional<Coche> findById(Long idCoche);
	
	public ByteArrayInputStream exportData();

}
