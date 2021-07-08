package es.dev.center.prueba.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.dev.center.prueba.model.ApiCalls;

public interface ApiCallsDAO extends MongoRepository<ApiCalls, String>{

}
