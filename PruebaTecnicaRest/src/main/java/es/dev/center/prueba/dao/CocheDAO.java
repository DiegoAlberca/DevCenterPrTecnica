package es.dev.center.prueba.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.dev.center.prueba.model.Coche;

@Repository
public interface CocheDAO extends CrudRepository<Coche, Long> {

}
