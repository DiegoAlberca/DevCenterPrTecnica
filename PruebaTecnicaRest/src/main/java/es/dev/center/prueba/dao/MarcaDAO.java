package es.dev.center.prueba.dao;

import org.springframework.data.repository.CrudRepository;

import es.dev.center.prueba.model.Marca;

public interface MarcaDAO extends CrudRepository<Marca, Long> {

}
