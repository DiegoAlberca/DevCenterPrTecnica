package es.dev.center.prueba.service;

import java.util.Optional;

import es.dev.center.prueba.model.Marca;

public interface MarcaService {
	
	public Iterable<Marca> findAll();
	
	public Optional<Marca> findById(Long idMarca);

}
