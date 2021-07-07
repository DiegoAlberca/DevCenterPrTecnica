package es.dev.center.prueba.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.dev.center.prueba.model.Precio;

@Repository
public interface PrecioDAO extends CrudRepository<Precio, Long> {
	
	@Query("SELECT p FROM Precio p WHERE p.coche.id = :idCoche AND p.fechaInicio < :fecha AND p.fechaFin > :fecha ")
	public Precio findByCocheFecha(@Param("idCoche")Long coche, @Param("fecha") Date fecha);
	
}
