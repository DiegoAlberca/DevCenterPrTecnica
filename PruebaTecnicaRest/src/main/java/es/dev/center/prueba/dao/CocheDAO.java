package es.dev.center.prueba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.dev.center.prueba.model.Coche;

@Repository
public interface CocheDAO extends CrudRepository<Coche, Long> {
	
	@Query("SELECT c FROM Coche c WHERE c.color = :color ")
	public List<Coche> findByColor(@Param("color")String color);
	
	@Query("SELECT c FROM Coche c WHERE c.nombreModelo = :modelo ")
	public List<Coche> findByModelo(@Param("modelo")String modelo);
	
	@Query("SELECT c FROM Coche c WHERE c.marca.nombreMarca = :marca ")
	public List<Coche> findByMarca(@Param("marca")String marca);
	
	@Query("SELECT c FROM Coche c INNER JOIN Precio p ON c.id=p.coche.id WHERE p.precio >= :precio ")
	public List<Coche> findByMasPrecio(@Param("precio")Integer precio);
	
	@Query("SELECT c FROM Coche c INNER JOIN Precio p ON c.id=p.coche.id WHERE p.precio <= :precio ")
	public List<Coche> findByMenosPrecio(@Param("precio")Integer precio);

}
