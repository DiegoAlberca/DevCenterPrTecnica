package es.dev.center.prueba.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import es.dev.center.prueba.model.Coche;

public interface CocheService {
	
	public Iterable<Coche> findAll();
	
	public Optional<Coche> findById(Long idCoche);
	
	public ByteArrayInputStream exportData() throws IOException;
	
	public List<Coche> findByColor(@Param("color")String color);
	
	public List<Coche> findByModelo(@Param("modelo")String modelo);
	
	public List<Coche> findByMarca(@Param("marca")String marca);
	
	public List<Coche> findByMasPrecio(@Param("precio")Integer precio);
	
	public List<Coche> findByMenosPrecio(@Param("precio")Integer precio);

}
