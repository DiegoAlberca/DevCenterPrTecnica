package es.dev.center.prueba.dao;

import org.springframework.data.repository.CrudRepository;

import es.dev.center.prueba.model.Coche;

public interface CocheDAO extends CrudRepository<Coche, Long> {

}
