package es.dev.center.prueba.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.dev.center.prueba.model.ApiCalls;

@Repository
public interface ApiCallsDAO extends MongoRepository<ApiCalls, String>{

}
