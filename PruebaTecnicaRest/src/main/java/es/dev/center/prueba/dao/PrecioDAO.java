package es.dev.center.prueba.dao;

import org.springframework.data.repository.CrudRepository;

import es.dev.center.prueba.model.Precio;

public interface PrecioDAO extends CrudRepository<Precio, Long> {

}
