package es.dev.center.prueba.service;

import java.util.Date;
import java.util.Optional;

import es.dev.center.prueba.model.Precio;

public interface PrecioService {
	
	public Iterable<Precio> findAll();
	
	public Optional<Precio> findById(Long idPrecio);
	
	public Optional<Precio> findByCocheFecha(Long idCoche, Date fecha);
}
